package yb222ce_assign1;

public class IntNode {
	private IntNode next;
    private int value;

    IntNode(int n) {
        this.value = n;
    }

    void changeNext(IntNode node) {
        this.next = node;
    }

   
    public IntNode getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

}
