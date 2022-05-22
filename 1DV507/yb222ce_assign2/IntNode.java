package yb222ce_assign2;

public class IntNode {
	private IntNode next;
    private int value;

    /**
     * Constructor to create an IntNode
     * @param n int value to be stored in this node
     */
    IntNode(int n) {
        this.value = n;
    }

    /**
     * Change next node in the Linked List
     * @param node IntNode to be attached as next node
     */
    void changeNext(IntNode node) {
        this.next = node;
    }

    /**
     * Return the next IntNode
     * @return IntNode
     */
    public IntNode getNext() {
        return next;
    }

    /**
     * Get the int value of this IntNode
     * @return int
     */
    public int getValue() {
        return value;
    }
}



