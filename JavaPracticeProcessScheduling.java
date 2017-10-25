/* Sample program in Java demonstrating classes, interfaces, polymorphism etc. */

import java.lang.*; // for the Comparable interface. Not necessary to import, imported by default in Java
import java.util.*; // for the Comparator interface.

/* PROCESS CLASS */
class Process
{
	private Integer pId;
	private String pName;
	
	public Process(Integer pId, String pName)
	{
		this.pId = pId;
		this.pName = pName;
	}
	
	public String getPName()
	{
		return pName;
	}

	public Integer getPId()
	{
		return pId;
	}
};

/* PRIORITY CLASS */
class Priority implements Comparable/*<T>*/
{
	private Integer avgTime;
	private Integer medianTime;
	
	public Priority(Integer avgTime, Integer medianTime)
	{
		this.avgTime = avgTime;
		this.medianTime = medianTime;
	}
	
	public Integer getAvgTime()
	{
		return avgTime;
	}

	public Integer getMedianTime()
	{
		return medianTime;
	}

	/* Implementing compareTo() method based on avgTime */
	public int compareTo(Object o)
	{
		Priority p = (Priority) o;
		
		if(this.avgTime > p.avgTime) return 1;
		else if(this.avgTime < p.avgTime) return -1;
		else return 0;
	}
};

/* COMPARATOR BY AVGTIME CLASS IMPLEMENTING COMPARATOR INTERFACE */
class ComparatorByAvgTime implements Comparator/*<T>*/
{
	public int compare(Object o1, Object o2)
	{
		Priority p1 = (Priority) o1;
		Priority p2 = (Priority) o2;
		
		if(p1.getAvgTime() > p2.getAvgTime()) return 1;
		else if(p1.getAvgTime() < p2.getAvgTime()) return -1;
		else return 0;
	}
}

/* COMPARATOR BY MEDIANTIME CLASS IMPLEMENTING COMPARATOR INTERFACE */
class ComparatorByMedianTime implements Comparator/*<T>*/
{
	public int compare(Object o1, Object o2)
	{
		Priority p1 = (Priority) o1;
		Priority p2 = (Priority) o2;
		
		if(p1.getMedianTime() > p2.getMedianTime()) return 1;
		else if(p1.getMedianTime() < p2.getMedianTime()) return -1;
		else return 0;
	}
}

/* BINARY SEARCH TREE CLASS */
class BinarySearchTree
{
	class Node
	{
		Priority key; // priority-based key
		Process value; // process is the value associated with the key
		Node left;
		Node right;
		
		Node(Priority key, Process value)
		{
			this.key = key;
			this.value = value;
		}
	};
	
	private Node root = null;
	
	/* Insertion with Comparable (uses Comparable interface implemented by Priority class to compare its objects) */
	public void insertWithComparable(Priority key, Process value)
	{
		root = insertWithComparable(root, key, value);
	}
	
	private Node insertWithComparable(Node n, Priority key, Process value)
	{
		if(n == null)
			return new Node(key, value);

		if(key.compareTo(n.key) == 0)
			n.right = insertWithComparable(n.right, key, value); // key (priority) is same, so just insert in right (here we can't discard another process with same priority)
		else if(key.compareTo(n.key) < 0)
			n.left = insertWithComparable(n.left, key, value);
		else if(key.compareTo(n.key) > 0)
			n.right = insertWithComparable(n.right, key, value);
		
		return n;
	}

	/* Insertion with Comparator (uses Comparator interface implemented by various comparator classes to compare Priority objects) */
	public void insertWithComparator(Priority key, Process value)
	{
		Comparator cmp = new ComparatorByMedianTime();
		root = insertWithComparator(root, key, value, cmp);
	}
	
	private Node insertWithComparator(Node n, Priority key, Process value, Comparator cmp)
	{
		if(n == null)
			return new Node(key, value);

		if(cmp.compare(key, n.key) == 0)
			n.right = insertWithComparator(n.right, key, value, cmp); // key (priority) is same, so just insert in right (here we can't discard another process with same priority)
		else if(cmp.compare(key, n.key) < 0)
			n.left = insertWithComparator(n.left, key, value, cmp);
		else if(cmp.compare(key, n.key) > 0)
			n.right = insertWithComparator(n.right, key, value, cmp);
		
		return n;
	}
	
	/* InOrder Traversal */
	public void inOrder()
	{
		inOrder(root);
	}
	
	private void inOrder(Node n)
	{
		if(n == null) return;
		
		inOrder(n.left);
		System.out.print(n.value.getPName() + " ");
		inOrder(n.right);	
	}
	
	/* Clear the BST */
	public void clear()
	{
		root = null;
	}
};

/* MAIN CLASS */
public class JavaPracticeProcessScheduling
{
	public static void main(String[] args)
	{
		BinarySearchTree bst = new BinarySearchTree();
		
		Process proc1 = new Process(1, "Process1");
		Priority prio1 = new Priority(20, 30);
		
		Process proc2 = new Process(1, "Process2");
		Priority prio2 = new Priority(10, 40);
		
		Process proc3 = new Process(1, "Process3");
		Priority prio3 = new Priority(30, 50);
		
		bst.insertWithComparable(prio1, proc1);
		bst.insertWithComparable(prio2, proc2);
		bst.insertWithComparable(prio3, proc3);
		
		System.out.print("\nInOrder: ");
		bst.inOrder();
		
		bst.clear();

		System.out.print("\n---------------------\n");
		
		bst.insertWithComparator(prio1, proc1);
		bst.insertWithComparator(prio2, proc2);
		bst.insertWithComparator(prio3, proc3);

		System.out.print("\nInOrder: ");
		bst.inOrder();
	}
};
