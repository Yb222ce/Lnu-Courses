package yb222ce_assign2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SalaryRevision {
	public static void main(String[] args) {
		System.out.print("Provide salaries (and terminate input with 'X'): ");
		Scanner scan = new Scanner (System.in);
		ArrayList<Integer> salary = new ArrayList<Integer> ();
	
		while (scan.hasNextInt()) {
		    salary.add(scan.nextInt()); 
		    
		}
		
		Collections.sort(salary);
		
		computeMedian (salary);
		computeAverage (salary);
		computeGap (salary);
		
		scan.close();
	}
	
	public static void computeAverage (ArrayList<Integer> adam) 	{
		int sum = 0 , average = 0 ;
		for (int salary : adam) {
			sum += salary;
		}
	     average = sum / adam.size();
	     System.out.println("Average: "+average);
	}
	
	public static void computeMedian(ArrayList <Integer> adam) {
		int median = 0;
		int size = adam.size();
		
		if (size % 2 == 0) 
		
			 median = (adam.get(size / 2) + adam.get(size / 2 - 1) ) / 2 ;
		else 
			median = adam.get(size / 2) ;
		 
		  
		System.out.println("Median: "+median);
		
	}
	
	public static void computeGap (ArrayList <Integer> adam) {
		
		int gap = adam.get(adam.size()-1) - adam.get(0) ;
		System.out.println("Gap: "+ gap); 
	}
}
