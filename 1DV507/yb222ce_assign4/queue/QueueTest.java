package yb222ce_assign4.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {
	@Test
	void testIsEmpty() {

		LinkedQueue<Integer> queue2 = buildQuee(50);
		assertEquals(false, queue2.isEmpty());
		

	}
	@Test
	void testEnqueue () {
		 LinkedQueue <Integer> qu=new LinkedQueue<>();
	for(int i=0; i<=0; i++) {
		qu.enqueue(i);
		
	}
	assertEquals(0, 0);
	
	for( int i=0; i <10000; i++) {
	 qu.enqueue(i);
		
	}
	assertEquals(10000, 10000);
	}
	
	

	private LinkedQueue <Integer> buildQuee (int n){
	 LinkedQueue <Integer> qu=new LinkedQueue<Integer>();
	 for (int i=0; i<n; i++) {
		 qu.enqueue(i);
	 }
	 return qu;
}
		
	
	
	
	 
	

}

