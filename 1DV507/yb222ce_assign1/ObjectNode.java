package yb222ce_assign1;

public class ObjectNode {
	private Object object	= null;
	private ObjectNode link = null;
	
	/**
	 * Default constructor for ObjectNode,
	 * a fundamental piece in implementation of linked collections
	 * @param object - The Object the node corresponds
	 */
	public ObjectNode(Object object)
	{
		this.object = object;
	}
	
	/**
	 * Adds an ObjectNode as a reference in the head-tail link approach
	 * @param link - Reference to next ObjectNode
	 */
	public void link(ObjectNode link)
	{
		this.link = link;
	}
	
	/**
	 * Returns the Object this class represents.
	 * @return The Object it corresponds
	 */
	public Object value()
	{
		return object;
	}
	
	/**
	 * Returns true is the next node is not null.
	 * @return True if next() won't return null
	 */
	
	public boolean hasNext()
	{
		return link != null;
	}
	
	/**
	 * Returns the next node referenced by this node.
	 * @return The next reference in the link.
	 */
	public ObjectNode next()
	{
		return link;
	}
	
	


}


