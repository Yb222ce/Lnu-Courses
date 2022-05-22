package yb222ce_assign2;

import java.util.Scanner;

public class CountDigits {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Provide a positive integer: ");
		int number = scan.nextInt();
		String text = Integer.toString(number);

		int zero = 0, odd = 0, even = 0 ;
		
		if (number > 0) {
		
		for (int i = 0; i < text.length(); i++) {
 
			if (text.charAt(i) == '0') 
				zero++;
			
			 else if (text.charAt(i) % 2 == 0) 
				even++;
			
			 else 
				odd++;
			
		}
		
		  System.out.print("Zeros: " + zero + "\nOdd: " + odd + "\nEven: " + even);
		
		}
		 
		else

		System.err.print("Number should be a positive integer" );
	
		scan.close();
	}
}
