package yb222ce_assign3;

import java.util.Scanner;

public class PascalMain {
	 private static int[] pascalRow(int n) {
	        int[] pt = new int[n + 1];
	        if (n == 0) {
	            pt[0] = 1;
	            return pt;
	        } else {
	            int[] ppt = pascalRow(n - 1);
	            pt[0] = pt[n] = 1;
	            for (int i = 1; i < n; i++) {
	                pt[i] = ppt[i - 1] + ppt[i];
	            }

	            return pt;
	        }

	    }

	    public static void main(String[] args) throws Exception {

	        Scanner scn = new Scanner(System.in);
	        System.out.print("Enter the row: ");
	        int row = scn.nextInt();
	        if (row >= 0) {
	            int[] result = pascalRow(row);
	            for (int i = 0; i < result.length; ++i) {
	                System.out.print(result[i] + " ");
	            }
	        } else System.err.println("Cant be negative");
	        scn.close();

	    }
	}


