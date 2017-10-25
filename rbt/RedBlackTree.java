package rbt;

// import queue.Queue;
import java.util.LinkedList; // for generic queue implementation

public class RedBlackTree {
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node {
		int     key;		// key
//		int     value;		// value of the key (optional to use)
		boolean color;      // color of the parent edge. true implies RED and false implies BLACK
		Node    left;		// left child node
		Node    right;		// right child node

		public Node(int key, boolean color) {
			this.key = key;
			this.color = color;
			this.left = this.right = null;
		}
	}; // Node class closed
	
	private Node root = null;

	
	/* GET NODE HAVING THE GIVEN KEY */
	private Node getNode(Node n, int key) {
		if(n == null)
			return null;
		
		if(n.key == key)
			return n;
		else if(key < n.key)
			return getNode(n.left, key);
		else
			return getNode(n.right, key);
	}

	
	/* INSERTION */
	public void insert(int key) {
		root = insert(root, key, RED);
	}
	private Node insert(Node n, int key, boolean color) {
		if(n == null) return new Node(key, color);

		if(n.key == key)
			; // duplicate found.
		else if(key < n.key)
			n.left = insert(n.left, key, color);
		else
			n.right = insert(n.right, key, color);
		
		// balancing the tree after node is inserted (cases according to left leaning Red Black Tree)
		if(isRed(n.right) && !isRed(n.left)) // if a red link is on the right side but not on the left side, we rotate it to the left
			n = rotateLeft(n);
		if(isRed(n.left) && isRed(n.left.left)) // if 2 consecutive red links (i.e. 3 nodes) are there on the left side so that it is conceptually a 4-node (a 4-branched node with 3 values), we rotate it to the right to pop-up the middle node
			n = rotateRight(n);
		if(isRed(n.left) && isRed(n.right)) // if both left and right child links are red (the element was popped-up from a 4-node), we flip the link colors (child links to black and parent link to red)
			flipColors(n);
		
		return n;
	}

	/* CHECK IF COLOR OF THE LINK OF A NODE IS RED (The link to its parent) */
	private boolean isRed(Node n) {
		if(n == null) return false;
		return n.color == RED;
	}

	/* ROTATE TO LEFT */
	private Node rotateLeft(Node n) {
		Node t = n.right;
		n.right = t.left;
		t.left = n;
		
		t.color = n.color;
		n.color = RED;
		
		return t;
	}

	/* ROTATE TO RIGHT */
	private Node rotateRight(Node n) {
		Node t = n.left;
		n.left = t.right;
		t.right = n;
		
		t.color = n.color;
		n.color = RED;
		
		return t;
	}

	/* FLIP COLORS OF EDGES ASSOCIATED WITH A NODE (Two RED child links to BLACK and BLACK parent link (if any) to RED) */
	private void flipColors(Node n) {
		n.left.color = n.right.color = BLACK;
		n.color = RED;
	}


	/* IN ORDER TRAVERSAL */
	public void inOrderTraverse() {
		System.out.println();
		inOrderTraverse(root);
	}
	private void inOrderTraverse(Node n) {
		if(n == null) return;

		inOrderTraverse(n.left);
	    System.out.print(n.key + " ");
	    inOrderTraverse(n.right);
	}
	
	
	/* PRE ORDER TRAVERSAL */
	public void preOrderTraverse() {
		System.out.println();
		preOrderTraverse(root);
	}
	private void preOrderTraverse(Node n) {
		System.out.print(n.key + " ");
		if (n.left != null)  preOrderTraverse(n.left);
		if (n.right != null) preOrderTraverse(n.right);
	}

	
	/* POST ORDER TRAVERSAL */
	public void postOrderTraverse() {
		System.out.println();
		postOrderTraverse(root);
	}
	private void postOrderTraverse(Node n) {
		if(n == null) return;
		
		postOrderTraverse(n.left);
		postOrderTraverse(n.right);
		System.out.print(n.key + " ");
	}

	
	/* LEVEL ORDER TRAVERSAL */
	public void levelOrderTraverse() {
		System.out.println();
		levelOrderTraverse(root);
	}
	private void levelOrderTraverse(Node root) {
		if(root == null) return;
		
		Queue<Node> q = new Queue<Node>();
		
		q.insert(root);
		while(q.hasItems()) {
			Node n = q.delete();
			System.out.print(n.key + " ");
			
			if(n.left != null)  q.insert(n.left);
			if(n.right != null) q.insert(n.right);
		}
	}

	
	/* HEIGHT OF TREE (Aka. max depth in a tree, i.e. the depth of the deepest leaf node) */
	public int height() {
		return height(root);
	}
	private int height(Node n) {
		if(n == null)
			return -1;
		else
			return 1 + Math.max(height(n.left), height(n.right));
	}

	
	/* TOP VIEW */
	public void topView() {
		System.out.println();
		topViewLeft(root);
		if(root != null)
			topViewRight(root.right);
	}
	private void topViewLeft(Node n) {
		if(n == null) return;

		topViewLeft(n.left);
		System.out.print(n.key + " ");
	}
	private void topViewRight(Node n) {
		if(n == null) return;

		System.out.print(n.key + " ");
		topViewRight(n.right);
	}

	
	/* FIND MIN */
	public int min() {
		if(root == null) return Integer.MIN_VALUE;
		return min(root);
	}
	private int min(Node n) {
		if(n.left == null)
			return n.key;
		else
			return min(n.left);
	}


	/* FIND MAX */
	public int max() {
		if(root == null) return Integer.MAX_VALUE;
		return max(root);
	}
	private int max(Node n) {
		if(n.right == null)
			return n.key;
		else
			return max(n.right);
	}
	

	/* DELETE MIN */
	public void deleteMin() {
		if(root == null) return;
		root = deleteMin(root);
	}
	private Node deleteMin(Node n) {
		if(n.left == null)
			return n.right;
		else
			n.left = deleteMin(n.left);

		return n;
	}


	/* DELETE MAX */
	public void deleteMax() {
		if(root == null) return;
		root = deleteMax(root);
	}
	private Node deleteMax(Node n) {
		if(n.right == null)
			return n.left;
		else
			n.right = deleteMax(n.right);
		
		return n;
	}

	
	/* DELETE GIVEN NODE */
	public void delete(int key) {
		root = delete(root, key);
	}
	private Node delete(Node n, int key) {
		if(n == null)
			return null;

		/* If this current node has the key (i.e. node n is to be deleted) */
		if(n.key == key) {
			if(n.left == null) return n.right; // if n has no left child, just replace it with its right child tree/null
			else
			if(n.right == null) return n.left; // if n has no right child, just replace it with its left child tree/null
			
			/*
			 * Node n has both children, left as well as right
			 * 
			 * Find the minimum element in its right sub-tree.
			 * Now the minimum element will never have a left child but may have a right child sub-tree.
			 * Move its right child to its parent's left link (where minimum was originally connected) and remove minimum
			 * Also, minimum's right link shall attach to the actual right side of node n to be deleted
			 * 
			 * Finally, place the minimum element (with its modified child tree structure) in place of n
			 * And make it's left link to the left child of n
			 */
			Node temp = n; // copy actual n in temp
			n = getMinNode(n.right); // now n has min node from the right sub-tree of n
			n.right = deleteMin(temp.right); // delete minimum node in right sub-tree and place its right child (if any) as its (min's) parent's left link instead.
											 // also, return the modified structure of the right sub-tree to left link of min node (stored in n).
			n.left = temp.left; // make the left link of the prepared n to left child of temp (actual node n)
			return n; // return the modified node structure replacing original n
		}
		/* Otherwise search the nodes for the key */
		else if(key < n.key) n.left = delete(n.left, key); // key is in the left sub-tree
		else				 n.right = delete(n.right, key); // key is in the right sub-tree
		
		return n;
	}
	private Node getMinNode(Node n) {
		if(n.left == null)
			return n;
		else
			return getMinNode(n.left);
	}

	
	/* SIZE OF TREE (No. of elements) */
	public int size() {
		if(root == null) return Integer.MIN_VALUE;
		return size(root);
	}
	private int size(Node n) {
		if(n == null)
			return 0;

		return size(n.left) + 1 + size(n.right);
	}

	
	/* PARENT OF A NODE (When parent references were not stored) */
	public int parent(int key) {
		return parent(root, key); // find that node's parent's key
	}
	private int parent(Node n, int key) {
		if(n == null)
			return Integer.MIN_VALUE;
		
		boolean foundLeft = false;
		boolean foundRight = false;
		if(n.left != null)
			foundLeft = (n.left.key == key) ? true : false;
		if(n.right != null)
			foundRight = (n.right.key == key) ? true : false;

		if(foundLeft || foundRight)
			return n.key;
		else if(key < n.key)
			return parent(n.left, key);
		else
			return parent(n.right, key);
	}

	
	/* KTH SMALLEST ELEMENT */
	public int kthSmallestElement(int k) {
		return kthSmallestElement(root, k);
	}
	private int kthSmallestElement(Node n, int k) {
		if(n == null)
			return Integer.MIN_VALUE;

		if(size(n.left) + 1 == k)
			return n.key;
		else if(k > size(n.left))
			return kthSmallestElement(n.right, k - (size(n.left) + 1));
		else
			return kthSmallestElement(n.left, k);
	}

	
	/* RANK OF A NODE (When parent references and sub-tree sizes were not stored) */
	public int rank(int key) {
		if(getNode(root, key) == null)
			return Integer.MIN_VALUE; // node not found
		else
			return rank(root, key);
	}
	private int rank(Node n, int key) {
		if(n.key == key) // if key found, then return size of its left sub-tree, because all left elements must be smaller
			return size(n.left);

		if(key > n.key) // if key is greater, find it in the right sub-tree recursively. Also, all the left elements + 1 (the current element) must be smaller than it.
			return 1 + size(n.left) + rank(n.right, key);
		else
			return rank(n.left, key); // if key is smaller, find it in the left sub-tree recursively.
	}

	
	/* CLEAR THE TREE */
	public void clear() {
		root = null;
	}
};


/* GENERIC QUEUE IMPLEMENTATION WITH LINKED LIST */
class Queue<T> {
	private LinkedList<T> list = new LinkedList<T>();

	public void insert(T item) {
		list.addLast(item);
	}	
	public T delete() {
		return list.poll();
	}
	public boolean hasItems() {
		return !list.isEmpty();
	}
	public int size() {
		return list.size();
	}
};