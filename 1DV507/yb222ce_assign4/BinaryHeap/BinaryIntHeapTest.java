package yb222ce_assign4.BinaryHeap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class BinaryIntHeapTest {
	private static int test_count = 0;

	@Before
	public void setUp() {
		test_count++;
		System.out.println("Test "+ test_count);
	}
	

	@After
	public void tearDown() {}
	
	@Test
	public void testBinaryIntHeapConstructors(){
		
		BinaryIntHeap test=new BinaryIntHeap();
		assertEquals(test.size(), 0);
		
	}
	
	@Test
	public void testInsert(){
		BinaryIntHeap test=new BinaryIntHeap();
		test.insert(11);
		test.insert(10);
		test.insert(7);
		test.insert(9);
		test.insert(5);
		test.insert(6);
		test.insert(4);
		test.insert(8);
		test.insert(2);
		test.insert(3);
		test.insert(1);
		
		String desiredResult="[empty,11,10,7,9,5,6,4,8,2,3,1,]";
		
		assertEquals(test.toString(), desiredResult);
		assertEquals(test.size(),11);
		
	}
	
	@Test
	public void testPullHighest(){
		
		BinaryIntHeap test=new BinaryIntHeap();
		test.insert(11);
		test.insert(10);
		test.insert(7);
		test.insert(9);
		test.insert(5);
		test.insert(6);
		test.insert(4);
		test.insert(8);
		test.insert(2);
		test.insert(3);
		test.insert(1);
		
		assertEquals(test.pullHighest(),11);
		String desiredResult="[empty,10,9,7,8,5,6,4,1,2,3,]";
		assertEquals(test.toString(), desiredResult);
		
		assertEquals(test.pullHighest(),10);
		String desiredResult2="[empty,9,8,7,3,5,6,4,1,2,]";
		assertEquals(test.toString(), desiredResult2);
		
		
	}
	
	@Test
	public void testSize(){
		
		BinaryIntHeap test=new BinaryIntHeap();
		test.insert(11);
		test.insert(10);
		test.insert(7);
		test.insert(9);
		test.insert(5);
		test.insert(6);
		test.insert(4);
		test.insert(8);
		test.insert(2);
		test.insert(3);
		test.insert(1);
		assertEquals(test.size(),11);
		test.pullHighest();
		assertEquals(test.size(),10);
		
	}
	
	@Test
	public void testIsEmpty(){
		
		BinaryIntHeap test=new BinaryIntHeap();
		assertTrue(test.isEmpty());
		
		test.insert(11);
		assertFalse(test.isEmpty());
		
		test.pullHighest();
		assertTrue(test.isEmpty());
		
	}
	
	@Test
	public void testToString(){
		
		BinaryIntHeap test=new BinaryIntHeap();
		test.insert(11);
		test.insert(10);
		test.insert(7);
		test.insert(9);
		test.insert(5);
		test.insert(6);
		test.insert(4);
		test.insert(8);
		test.insert(2);
		test.insert(3);
		test.insert(1);
		
		String desiredResult="[empty,11,10,7,9,5,6,4,8,2,3,1,]";
		
		assertEquals(test.toString(), desiredResult);
		
	}
	


}
	