package yb222ce_assign2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedQueueTest {
	private static int testCount = 0;

    /* Is executed before every test method (not test case).*/
    @Before
    public void setTestCount(){
        testCount ++;
        System.out.println("Test " + testCount);
    }

    @After
    public void tearDown() {
        System.out.println(" --- done with test "+ testCount);
    }

    @Test
    public void testSize() {
        LinkedQueue q = new LinkedQueue();
        assertEquals(0,q.size());
    }

    @Test
    public void isEmpty() {
        //test the boolean isEmpty
        LinkedQueue q1 = build(0);
        assertEquals(true,q1.isEmpty());

        LinkedQueue q2 = build(4);
        assertEquals(false,q2.isEmpty());
    }

    @Test
    public void enqueue() {
        //Test enqueue using build method, check the first element and size
        LinkedQueue q1 = build(5); //0,1,2,3,4
        q1.enqueue(11);
        assertEquals(11,q1.last());
        assertEquals(6,q1.size());

        q1.enqueue(3);
        assertEquals(3,q1.last());
        assertEquals(7,q1.size());
    }

    @Test
    public void dequeue() {
        //Test if empty and throws exception
        LinkedQueue q1 = build(0);
        assertThrows(RuntimeException.class, q1::dequeue);

        //Test dequeue using build method, check the first element and size
        LinkedQueue q2 = build(5); //0,1,2,3,4
        assertEquals(0,q2.first());

        q2.dequeue();
        assertEquals(1,q2.first());
        assertEquals(4,q2.size());

        q2.dequeue();
        assertEquals(2,q2.first());
        assertEquals(3,q2.size());
    }

    @Test
    public void first() {
        //test if it is empty throws exception
        LinkedQueue q1 = build(0);
        assertThrows(RuntimeException.class, q1::first);

        LinkedQueue q2 = build(4); //0,1,2,3
        assertEquals(0,q2.first());

        //test after enqueue
        q2.dequeue();
        assertEquals(1,q2.first());
        q2.dequeue();
        assertEquals(2,q2.first());
    }

    @Test
    public void last() {
        //test if empty throw exception
        LinkedQueue q1 = build(0);
        assertThrows(RuntimeException.class, q1::last);

        //test using build method and enqueue method
        LinkedQueue q2 = build(7); //0,1,2,3,4,5,6
        assertEquals(6,q2.last());
        q2.enqueue(3);
        assertEquals(3,q2.last());

        LinkedQueue q3 = build(6); //0,1,2,3,4,5
        assertEquals(5,q3.last());
        q2.enqueue(10);
        assertEquals(10,q2.last());
    }

    @Test
    public void testToString() {
        LinkedQueue q = build(4); //0,1,2,3
        assertEquals("0 1 2 3 ",q.toString());

        LinkedQueue q1 = build(7); //0,1,2,3,4,5,6
        assertEquals("0 1 2 3 4 5 6 ",q1.toString());
    }

    //Private help methods
    private LinkedQueue build(int size){
        LinkedQueue queue = new LinkedQueue();
        for (int i=0;i<size;i++)
            queue.enqueue(i);
        return queue;
    }
}



