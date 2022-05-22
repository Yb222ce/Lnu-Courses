package yb222ce_assign4.queue;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T>{
	private int size=0;
	private Node head;
	private Node tail;
	
	class Node{
		T data;
		Node next;
		
	}
	public LinkedQueue() {
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head== null;
	}

	@Override
	public void enqueue(T t) {
		if( isEmpty()==true) {
			Node node=new Node();
			node.data=t;
			node.next=head ; 
			head=node;
			tail=head;
					
		}
		else {
			Node node = new Node();
			node.next=head;
			head=node;
			tail=head;
			
		}
		
	}

	@Override
	public T dequeue() {
		if( isEmpty()==true ) {
			throw new NoSuchElementException();
		}
		T data=head.data;
		head= head.next;
		size--;
		
		return data;
	}

	@Override
	public T first() {
		if(head==null) {
			throw new NoSuchElementException();
		}
		
		return head.data;
	}

	@Override
	public T last() {
		if(tail==null) {
			throw new NoSuchElementException();
		}
		return tail.data;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkQueueIterator();
	}
	
public class LinkQueueIterator implements Iterator<T>{
 private Node position;
 public LinkQueueIterator() {
	 position=null;
 }
	@Override
	public boolean hasNext() {
		if (position==null){
			return head!=null;
		}
		return position.next!=null;
	}

	@Override
	public T next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		else if (position==null) {
			position=head;
		}
		return position.data;
	}
		
		
	}
}
