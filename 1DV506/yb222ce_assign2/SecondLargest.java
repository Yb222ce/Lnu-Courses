package yb222ce_assign2;

import java.util.Scanner;

public class SecondLargest {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Provide 10 integers: ");
		int large = 0, secondLarge = 0;
		for (int i = 0; i < 10; i++) {
			int number = scan.nextInt();

			if (number > large) {
				secondLarge = large;
				large = number;
			} else if (number > secondLarge && number < large)

				secondLarge = number;

		}

		System.out.print("The second largest is: " + secondLarge);
		scan.close();
	}
}
