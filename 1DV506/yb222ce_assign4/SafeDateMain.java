package yb222ce_assign4;

import java.util.Scanner;

public class SafeDateMain {
	public static void main(String[] args) {
	      testDateByDisplaying();
	    }
	    public static void testDateByDisplaying() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter year");
	        int yearEntry = sc.nextInt();
	       
	        while (true){
	            if (yearEntry==0){
	                break;
	                
	            }
	            try {
	                System.out.println("Enter month");
	                int monthEntry = sc.nextInt();
	                System.out.println("Enter day");
	                int dayEntry = sc.nextInt();
	                DateFormat date = new DateFormat(yearEntry,monthEntry,dayEntry,'-','b');
	                System.out.println("Date: "+date.getDate(true));
	            }catch (IllegalArgumentException ex){
	                System.out.println("Ups... that is not possible, error is:"+" "+ex.getMessage());
	            }
	            System.out.println("Enter year");
	           yearEntry=sc.nextInt();
	          
	        }
	        sc.close();
	    }
        
}
