package yb222ce_assign4.Time;
import java.util.Comparator;
import java.util.Random;

public class TimeExercise7 {
	 public static void main(String[] args) {
	        insertionInt();

	        insertionString();

	        mergeInt();

	        mergeString();

	    }
	    public static void insertionInt(){
	        int[] intArray;
	        int count = 10000;
	        long time = 0;
	        do {
	            intArray = generateInt(count);
	            time = insertionInt(intArray);
	            if (time > 1000) {
	                count = count / 2;
	            }
	            else {
	                count = count + count / 2;
	            }
	        } while (time < 975 || time > 1025);
	        System.out.println("In " + time/1000.0 + " second, sort "+intArray.length+" int array by insertion");
	    }
	    public static void insertionString(){
	        String[] StringArray;
	        int count = 10000;
	        long time = 0;
	        do {
	            StringArray = generateStringArray(count);
	            time = insertionString(StringArray);
	            if (time > 1000) {
	                count = count / 2;
	            }

	            else {
	                count = count + count / 2;
	            }

	        } while (time < 975 || time > 1025);
	        System.out.println("In " + time/1000.0 + " second, sort "+StringArray.length+" String array by insertion");
	    }
	    public static void mergeInt(){
	        int[] intArray;
	        int count = 10000;
	        long time = 0;
	        do {
	            intArray = generateInt(count);
	            time = mergeInt(intArray);
	            if (time > 1000) {
	                count = count / 2;
	            }
	            else {
	                count = count + count / 2;
	            }
	        } while (time < 975 || time > 1025);
	        System.out.println("In " + time/1000.0 + " second, sort "+intArray.length+" int array by merge");
	    }
	    public static void mergeString(){
	        String[] StringArray;
	        int count = 10000;
	        long time = 0;
	        do {
	            StringArray = generateStringArray(count);
	            time = mergeString(StringArray);
	            if (time > 1000) {
	                count = count / 2;
	            }

	            else {
	                count = count + count / 2;
	            }

	        } while (time < 975 || time > 1025);
	        System.out.println("In " + time/1000.0 + " second, sort "+StringArray.length+" String array by merge");
	    }
	    public static long mergeInt(int[] array){
	        long before = System.currentTimeMillis();
	        Sort.mergeSort(array);
	        long after = System.currentTimeMillis();
	        return after-before;
	    }
	    public static long mergeString(String[] array){
	        long before = System.currentTimeMillis();
	        Comparator<String> Alphabetic = (s1, s2) -> s1.toLowerCase().compareTo(s2.toLowerCase());
	        Sort.mergeSort(array,Alphabetic);
	        long after = System.currentTimeMillis();
	        return after-before;
	    }
	    public static long insertionInt(int[] array){
	        long before = System.currentTimeMillis();
	        Sort.insertionSort(array);
	        long after = System.currentTimeMillis();
	        return after-before;
	    }
	    public static long insertionString(String[] array){
	        Comparator<String> Alphabetic = (s1, s2) -> s1.toLowerCase().compareTo(s2.toLowerCase());
	        long before = System.currentTimeMillis();
	        Sort.insertionSort(array,Alphabetic);
	        long after = System.currentTimeMillis();
	        return after-before;
	    }
	    public static int[] generateInt(int size){
	        Random rnd = new Random();
	        int[] randomInt = new int[size];
	        for (int i =0;i<size;i++){
	            randomInt[i] = rnd.nextInt(10000);
	        }
	        return randomInt;
	    }
	    public static String generateString(){
	        String s = "";
	        Random random = new Random();
	        for (int i = 0; i<10;i++){
	            int rInt = random.nextInt(26);
	            s = (char)('a'+rInt)+"";
	        }
	        return s;
	    }
	    public static String[] generateStringArray(int size){
	        String[] array = new String[size];
	        for (int i = 0; i < size; i++) {
	            array[i] = generateString();
	        }
	        return array;
	    }
	}


