package yb222ce_assign2;

import java.util.Scanner;

public class HighLow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		int number = (int) (Math.random() * 100) + 1;
		int guessNumber = 1;
		Scanner scan = new Scanner(System.in);
		System.out.println("Guess the number: ");
		System.out.print("Guess  " + guessNumber + ": ");
		int answer = scan.nextInt();

		for (int i = 1; i < 10; i++) {
			if (answer == number) {
				
				System.out.println("   Correct answer after only " + guessNumber + " guesses – Excellent!");
				guessNumber++;

				System.exit(-1);
			} else if (answer > number) {
				
				System.out.println("   Clue: lower");
				guessNumber++;
				System.out.print("Guess  " + guessNumber + ": ");
				answer = scan.nextInt();

			} else {
				
				System.out.println("   Clue: Higher");
				guessNumber++;
				System.out.print("Guess  " + guessNumber + ": ");
				answer = scan.nextInt();

			}

		}
		if (guessNumber > 9)
			System.out.print("\nSorry but you only have 10 chances to guess the number");

		scan.close();
	}
}
