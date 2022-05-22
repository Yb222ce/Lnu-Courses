package yb222ce_assign4.Time;

import java.util.Comparator;

public class Sort {
	public static int[] insertionSort(int[] in){
        for (int i = 0; i < in.length; i++){
            int currentNumber = in[i];
            int temp = i-1;
            while (temp >= 0 && in[temp] > currentNumber){
                //remove bigger number
                in[temp + 1] = in[temp];
                temp--;
            }
            //insert the sorted number
            in[temp + 1] = currentNumber;
        }
        return in;
    }
    public static String[] insertionSort(String[] in, Comparator<String> c){
        for (int i = 0; i < in.length; i++){
            String currentString = in[i];
            int temp = i-1;
            while (temp >= 0 && c.compare(in[temp],currentString)>0){
                //remove bigger number
                in[temp + 1] = in[temp];
                temp--;
            }
            //insert the sorted number
            in[temp + 1] = currentString;
        }
        return in;
    }
    public static int[] mergeSort(int[] in) {
        //only one element in the list
        if (in.length == 1) {
        }
        else {
            int[] left = new int[in.length / 2];
            int[] right = new int[in.length - left.length];
            System.arraycopy(in, 0, left, 0, left.length);
            System.arraycopy(in, left.length, right, 0, right.length);
            mergeSort(left);
            mergeSort(right);
            merge(left,right,in);
        }
        return in;
    }
    public static void merge(int[] left, int[] right, int[] update){
        int indexLeft = 0;
        int indexRight = 0;
        int indexUpdate = 0;

        while (indexLeft < left.length && indexRight < right.length){
            if (left[indexLeft]>right[indexRight]){
                update[indexUpdate] = right[indexRight];
                indexUpdate++;
                indexRight++;
            }
            else{
                update[indexUpdate] = left[indexLeft];
                indexUpdate++;
                indexLeft++;
            }
        }
        //only left is left or right
        while (indexLeft < left.length){
            update[indexUpdate] = left[indexLeft];
            indexUpdate++;
            indexLeft++;
        }
        while (indexRight < right.length){
            update[indexUpdate] = right[indexRight];
            indexUpdate++;
            indexRight++;
        }
    }
    public static String[] mergeSort(String[] in, Comparator<String> c){
        //only one element in the list
        if (in.length == 1) {
        }
        else {
            String[] left = new String[in.length / 2];
            String[] right = new String[in.length - left.length];
            System.arraycopy(in, 0, left, 0, left.length);
            System.arraycopy(in, left.length, right, 0, right.length);
            mergeSort(left,c);
            mergeSort(right,c);
            merge(left,right,in,c);
        }
        return in;
    }
    public static void merge(String[] left, String[] right,String[] update, Comparator<String> c){
        int indexLeft = 0;
        int indexRight = 0;
        int indexUpdate = 0;

        while (indexLeft < left.length && indexRight < right.length){
            if (c.compare(left[indexLeft],right[indexRight])>0){
                update[indexUpdate] = right[indexRight];
                indexUpdate++;
                indexRight++;
            }
            else{
                update[indexUpdate] = left[indexLeft];
                indexUpdate++;
                indexLeft++;
            }
        }
        //only left is left or right
        while (indexLeft < left.length){
            update[indexUpdate] = left[indexLeft];
            indexUpdate++;
            indexLeft++;
        }
        while (indexRight < right.length){
            update[indexUpdate] = right[indexRight];
            indexUpdate++;
            indexRight++;
        }
    }

}
