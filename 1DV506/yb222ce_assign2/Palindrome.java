package yb222ce_assign2;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Provide a line of text: ");
		String line = scan.nextLine() ;
		boolean isPalindrome = true ; 
		
		String text = line.toLowerCase();  
		
		for(int i = 0 , j = text.length()-1 ; i < j ; i++ , j-- ) 
		{
			if (!Character.isLetter(text.charAt(i)))
				break ;
			if (!Character.isLetter(text.charAt(j)))
				break ;
			
			if (text.charAt(i) != text.charAt(j)) 
			isPalindrome = false ;
		} 
		
		if (isPalindrome)
			System.out.print(line + " is palindrome");
		else 
			System.out.print(line + " is not palindrome");
		
		scan.close();
	}
}
