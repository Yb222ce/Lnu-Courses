package yb222ce_assigin1;
import java.util.*;
public class Change {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the price: ");
		double price = scan.nextDouble();
		System.out.print("Enter Payment Amount: ");
		double payment = scan.nextDouble();
		double remaningAmount = payment - price;
		remaningAmount = Math.round(remaningAmount);
		int change = (int) remaningAmount;

		// Find the number of thousand in the remaining amount
		int thousand = change / 1000;
		change = change % 1000;

		// Find the number of five hundred in the remaining amount
		int fiveHundred = change / 500;
		change = change % 500;

		// Find the number of two hundred in the remaining amount
		int twoHundred = change / 200;
		change = change % 200;

		// Find the number of one hundred in the remaining amount
		int oneHundred = change / 100;
		change = change % 100;

		// Find the number of fifty in the remaining amount
		int fifty = change / 50;
		change = change % 50;

		// Find the number of twenty in the remaining amount
		int twenty = change / 20;
		change = change % 20;

		// Find the number of ten in the remaining amount
		int ten = change / 10;
		change = change % 10;

		// Find the number of five in the remaining amount
		int five = change / 5;
		change = change % 5;

		// Find the number of two in the remaining amount
		int two = change / 2;
		change = change % 2;

		// Find the number of one in the remaining amount
		int one = change;

		System.out.println("\nChange: " + (int) remaningAmount + " Kronor");
		System.out.println("1000kr bills: " + thousand);
		System.out.println(" 500kr bills: " + fiveHundred);
		System.out.println(" 200kr bills: " + twoHundred);
		System.out.println(" 100kr bills: " + oneHundred);
		System.out.println("  50kr bills: " + fifty);
		System.out.println("  20kr bills: " + twenty);
		System.out.println("  10kr coins: " + ten);
		System.out.println("   5kr coins: " + five);
		System.out.println("   2kr coins: " + two);
		System.out.println("   1kr coins: " + one);

		scan.close();
	}

}
