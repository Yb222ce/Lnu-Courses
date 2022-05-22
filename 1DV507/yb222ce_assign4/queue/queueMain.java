package yb222ce_assign4.queue;

import java.util.Iterator;

public class queueMain {
	public static void main(String[] args) {
		LinkedQueue<Integer> qu= new LinkedQueue<Integer>();
		
		for(int i=0;i<10;i++) {
			qu.enqueue(i);
			
		}
		System.out.println("Elements in the queue"+"\n"+qu.toString());
			System.out.println("Size of the queue "+qu.size());
			System.out.println("First element "+ qu.first());
			System.out.println("Last element "+ qu.last());
			System.out.println("Removing first "+qu.dequeue());
			System.out.println("Elements in the queue"+"\n"+qu.toString());
			System.out.println("Removing first "+qu.dequeue());
			System.out.println("Removing first "+qu.dequeue());
			System.out.println("Elements in the queue"+"\n"+qu.toString());
			System.out.println("size of the queue "+qu.size());

		
			Iterator <Integer>it =qu.iterator();
            while (it.hasNext()) {
            	System.out.print(" "+it.next());
            }

	}
	

}
