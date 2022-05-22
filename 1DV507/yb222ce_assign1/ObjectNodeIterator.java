package yb222ce_assign1;

import java.util.Iterator;

public class ObjectNodeIterator implements Iterator<Object> {
	private final ObjectNode head; // head for rewinding
	private ObjectNode current;
	
	/**
	 * Default constructor for ObjectNodeIterator,
	 * it takes a ObjectNode that represents as the 'head'
	 * of a linked collection.
	 * @param node - the head of linked collection
	 */
	public ObjectNodeIterator(ObjectNode node)
	{
		head = new ObjectNode(null); // due to how the linked concept is implemented, start with a dummy object for head
		head.link(node);
		
		current = head;
	}
	
	@Override
	public boolean hasNext() {
		return current.hasNext();
	}

	@Override
	public Object next() {
		current = current.next();
		return current.value();
	}



	


}
