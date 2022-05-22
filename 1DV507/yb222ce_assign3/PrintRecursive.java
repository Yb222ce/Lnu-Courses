package yb222ce_assign3;

public class PrintRecursive {
	 private static void print(String str, int pos) {
		 
		 
	        System.out.print(str.charAt(pos));
	        if (pos == str.length() - 1)         //end Recursive
	            return;
	        print(str, pos + 1);               
	    }

	    private static void printReverse(String str, int pos) {
	        System.out.print(str.charAt(str.length() - pos - 1));
	        if (pos == str.length() - 1)         //end Recursive
	            return;
	        printReverse(str, pos + 1);
	    }

	    public static void main(String[] args) {
	        String str = "Hello Everyone!";

	        print(str, 0);
	        System.out.println(); // Line break
	        printReverse(str, 0);
	    }


}
