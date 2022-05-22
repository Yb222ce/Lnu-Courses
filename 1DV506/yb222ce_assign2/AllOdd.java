package yb222ce_assign2;

import java.util.Arrays;

public class AllOdd {
	public static void main(String[] args) {
        int digits [] = new int[10];
        for (int j =0 ; j<digits.length;j++){
            digits[j] = (int) (Math.random()*100+1);
        }
        System.out.println("Complete array:"+ Arrays.toString(digits));
        System.out.println("All odd numbers:");
        for (int digit:digits){
            if (digit%2!=0){
                System.out.print(digit+" ");
            }
        }
    }

}
 




