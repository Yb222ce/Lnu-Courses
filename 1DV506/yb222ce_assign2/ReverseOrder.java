package yb222ce_assign2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReverseOrder {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter positive integers. End by giving a negative integer: ");
		List<Integer> numbers = new ArrayList<Integer>();

		while (true) {

			System.out.print("Integer " + (numbers.size() + 1) + ": ");
			int num = scan.nextInt();

			if (num < 0)
				break;

			numbers.add(num);

		}
		Collections.reverse(numbers);

		System.out.println("\nNumber of positive integers: " + numbers.size());
		System.out.print("In reverse order: " + numbers);

		scan.close();
	}
}
