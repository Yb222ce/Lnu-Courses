package yb222ce_assign2;

import java.util.Iterator;

public class LinkedQueue implements IntQueue{
	private int size;
    private Node head;
    private Node tail;

    /**
     * constructor initial the size head and tail
     */
    public LinkedQueue() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Private inner Node clas
     */
    private class Node{
        int value;
        Node next = null;

        public Node(int v){
            value = v;
        }
    }

    /**
     * check the linkedList is empty
     * @return int current size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * check if it is empty
     * @return boolean if is empty return true
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * add element at end of queue
     * @param element is the int we need to add in the end of list
     */
    @Override
    public void enqueue(int element) {
        if (isEmpty()){ //add first element
            head = new Node(element);
            tail = head;
        }
        else{
            tail.next = new Node(element); //attach new node
            tail = tail.next; //update tail
        }
        size ++;
    }

    /**
     * return and remove first element.
     * @return first integer
     * @throws RuntimeException since the list is empty and only have one element
     */
    @Override
    public int dequeue() {
        if (isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        int first = head.value; //get the first element
        if (size == 1){ // if there is only one element in the list and after deleting the list is empty
            head = null;
            tail = null;
        }
        else {
            head = head.next;
        }
        size--;
        return first;
    }

    /**
     * get (without removing) first element
     * @return int
     * @throws RuntimeException since the list is empty
     */
    @Override
    public int first() {
        if (isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        return head.value;
    }

    /**
     * get (without removing) last element
     * @return the last int value
     * @throws RuntimeException since the list is empty
     */
    @Override
    public int last() {
        if (isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        return tail.value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ListIterator();
    }

    /**
     * Inner iterator class
     */
     private class ListIterator implements Iterator<Integer>{
        private Node node = head; // First node is head

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Integer next() {
            int val = node.value; // Read current value
            node = node.next; // Move one step ahead
            return val ;
        }
    }

    public String toString(){
        Node node = head;
        StringBuilder s = new StringBuilder();
        while (node != null) {
            s.append(node.value + " ");
            node = node.next;
        }
        return s.toString();
    }
}
		