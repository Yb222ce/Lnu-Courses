package yb222ce_assigin1;
import java.util.Scanner;
public class ShortName {
	public static void main(String[] args) {
		 Scanner scan = new Scanner (System.in) ;
	     
		 System.out.print("Enter First Name: ");
	     String firstName = scan.nextLine();
	     char c = firstName.charAt(0);
	     
	     System.out.print("Enter Last Name: ");
	     String lastName = scan.nextLine();
	     lastName = lastName + "   " ;
	     String sub = lastName.substring(0,4);
	     
	     System.out.println(c+". " + sub);
	     
		 
		 scan.close();
		}
}
