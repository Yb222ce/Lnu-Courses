package yb222ce_assign2;

import java.util.Scanner;

public class Backwards {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		System.out.print("Provide a line of text: ");
		String text = scan.nextLine();

		String back = "";
		for (int i = text.length() - 1; i >= 0; --i) {
			back = back + text.charAt(i);
		}
		System.out.print("Backwards: " + back);

		scan.close();

	}
}
