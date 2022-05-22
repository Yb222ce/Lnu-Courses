package yb222ce_assigin1;

import java.util.Random;

public class RandomSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random();

		int firstNumber  =  1 + rand.nextInt(100);
		int secondNumber =  1 + rand.nextInt(100);
		int thirdNumber  =  1 + rand.nextInt(100);
		int fourthNumber =  1 + rand.nextInt(100);
		int fifthNumber  =  1 + rand.nextInt(100);
		int sum = firstNumber + secondNumber + thirdNumber + fourthNumber + fifthNumber;

		System.out.println("Five random numbers: " + firstNumber + " " + secondNumber + " " 
		+ thirdNumber + " "+ fourthNumber + " " + fifthNumber);
		System.out.print("There sum is: " + sum);

	}
}
