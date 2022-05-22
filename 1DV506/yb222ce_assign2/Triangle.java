package yb222ce_assign2;

import java.util.Scanner;

public class Triangle {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("Provide an odd positive integer: ");
		int number = scan.nextInt();

		if (number % 2 != 0 && number > 0) {
			System.out.println("Right-Angled Triangle: ");

			for (int spaces = 0, asterisks = number; spaces < number; spaces++, asterisks--) {

				for (int x = 0; x < spaces; x++) {
					System.out.print(" ");
				}
				for (int x = 0; x < asterisks; x++) {
					System.out.print("*");

				}
				System.out.println();
			}

			System.out.println("\nIsosceles Triangle:");
			for (int spaces = number / 2, asterisks = 1; spaces >= 0; spaces--, asterisks += 2) {

				for (int x = 0; x < spaces; x++) {
					System.out.print(" ");
				}
				for (int x = asterisks; x > 0; x--) {
					System.out.print("*");

				}
				System.out.println();
			}
		} else
			System.err.print("Number shoiuld be odd postive integer.");
		scan.close();
	}
}


