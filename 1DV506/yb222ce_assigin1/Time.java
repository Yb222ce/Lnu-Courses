package yb222ce_assigin1;

import java.util.Scanner;

public class Time {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Enter Number Of Seconds: ");
		int sec = in.nextInt();

		int s = sec % 60;
		int m = sec / 60 % 60 ;
		int h = sec / 3600;

		System.out.print(h + " hours, " + m + " minutes and " + s + " seconds.");
		
		in.close();

	}
}
