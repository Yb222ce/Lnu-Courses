package yb222ce_assign4;
import java.io.*;

import java.io.FileNotFoundException;

public class CountingWords {
	 public static void main(String[] args) throws IOException {
	        File word = new File("/Users/yetnayetbelachew/eclipse-workspace/1DV506/src/yb222ce_assign4/lovecraft.txt");
	        try{
	            BufferedReader buff = new BufferedReader(new FileReader(word));

	            int max = 0;
	            String sentence;
	            while ((sentence = buff.readLine()) != null) {

	                if(!sentence.equals("") && !sentence.trim().matches("\\d+")) {
	                    max+=sentence.split(" ").length;
	                }
	            }
	            System.out.println("Number of words:"+" " +max);
	            buff.close();
	        }
	        catch (FileNotFoundException messageAlert){
	            System.out.println("Something goes wrong the file can not be opened!!!!!!!!");
	        }
	    }

}
