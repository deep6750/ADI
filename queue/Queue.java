package queue;

import java.util.LinkedList;

public class Queue<T> {
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