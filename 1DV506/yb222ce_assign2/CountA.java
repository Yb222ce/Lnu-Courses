package yb222ce_assign2;

import java.util.Scanner;

public class CountA {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Provide a line of text: ");
		String line = scan.nextLine();
		int na = 0 ,  nA = 0;
		
		 for (int i = 0 ; i < line.length() ; i++) {
			 if (line.charAt(i) == 'a') 
				 na++ ; 
			 
			 else  if (line.charAt(i) ==  'A') 
				 nA++ ;
           }
		 System.out.println("Number of 'a': " + na);
		 System.out.println("Number od 'A': " + nA);
	scan.close();
		
	}

}
