package yb222ce_assign3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class SortTester {
	private static int test_count = 0;

	@Before
	public void setup() {
		test_count++;
		System.out.println("Test: " + test_count);
	}

	@Test
	public void testInsertionSortInt() {
		SortingAlgorithms s = new SortingAlgorithms();
		int[] arr = { 32, 2, 4, 64, 1, 98, 5 };
		int[] sortedArr = s.insertionSort(arr);

		assertEquals(arr.length, sortedArr.length);

		for (int i = 0; i < sortedArr.length - 1; i++) {
			assertTrue(sortedArr[i] <= sortedArr[i + 1]);
		}
	}

	@Test
	public void testInsertionSortString() {
		SortingAlgorithms s = new SortingAlgorithms();
		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};

		String[] arr = { "Sort", "tesing", "tester", "1", "2", "3" };
		String[] sortedArr = s.insertionSort(arr, c);

		assertEquals(arr.length, sortedArr.length);

		for (int i = 0; i < sortedArr.length - 1; i++) {
			assertTrue(c.compare(sortedArr[i], sortedArr[i + 1]) < 0); // Check if ascending order
		}
	}
	

}
