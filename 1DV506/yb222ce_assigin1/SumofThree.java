package yb222ce_assigin1;

import java.util.Scanner;

public class SumofThree {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Provide a three digit number: ");

		int s = scan.nextInt();

		int ones = s % 10;
		int tens = (s / 10) % 10;
		int hundredths = s / 100;
		int sum = ones + tens + hundredths;

		System.out.print("Sum of digits: " + sum);
		
		scan.close();

	}

}
