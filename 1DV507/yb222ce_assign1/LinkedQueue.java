package yb222ce_assign1;

import java.util.Iterator;

public class LinkedQueue implements Queue {
	private int size = 0;
	private Node head = null;
	private Node tail = null;

	public int size() {
		return size;
	}


	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}

	}

	public void enqueue(int element) {
		if (head == null) {
			head = new Node(element);
			tail = head;
			size++;
		} else {
			tail.next = new Node(element);
			tail = tail.next;
			size++;
		}
	}

	public int dequeue() throws NullPointerException {
		if (isEmpty()) {
			throw new NullPointerException();
		}

		

		Node delete = head;
		Node proceed = head.next;
		head = proceed;
		size--;
		return delete.value;

	}

	
	public int first() {
		return head.value;
	}

	
	public int last() {
		return tail.value;
	}

	
	
	public String toString() {
		Iterator<Integer> iterator = iterator();
		StringBuilder str = new StringBuilder();
		str.append("[");
		while (iterator.hasNext()) {
			str.append(iterator.next());
			if (iterator.hasNext() != false) {
				str.append(",");
			}

		}
		str.append("]");
		return str.toString();
	}

	

	public Iterator<Integer> iterator() {
		return new listIterator();
	}

	private class listIterator implements Iterator<Integer> {
		private Node node = head;

		public Integer next() {
			int val = node.value;
			node = node.next;
			return val;
		}

		public boolean hasNext() {
			return node != null;
		}
	}


	private class Node {
		int value = 0;
		Node next = null;

		Node(int element) {
			this.value = element;
		}
	}

}
