package yb222ce_assign4;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class FileStatistics {
	 public static void main(String[] args) {

	        File informationOfPath = new File("/Users/yetnayetbelachew/eclipse-workspace/1DV506/src/yb222ce_assign4/lovecraft.txt");
	        int sumOfEveryThing = 0, lineNoElement = 0;
	        int txtLine = 0, pgNumber = 0;

	        try {
	            Scanner sc = new Scanner(informationOfPath);
	            while (sc.hasNext()) {
	                String message = sc.nextLine().replaceAll("\\s", " ").trim();
	                if (message.equals("")) {
	                    lineNoElement++;
	                } else {
	                    if(message.trim().matches("\\d+")) {
	                        pgNumber++;
	                    } else {
	                        txtLine++;
	                    }
	                }
	                sumOfEveryThing++;
	            }
	            sc.close();
	            printResults(sumOfEveryThing,lineNoElement,txtLine,pgNumber);
	        } catch (FileNotFoundException exceptionErrorMessage) {
	            System.out.println("The requested file has not been identified");
	        } catch (Exception exceptionErrorMessage2) {
	            System.out.println("Warning! \"Error\" " + exceptionErrorMessage2.getMessage());
	        }
	    }
	    static void printResults(int totalLines,int emptyLines,int lines,int pageIdentifier) {
	        System.out.println("Lovecraft statistics:");
	        System.out.println("Total lines:\t\t" + totalLines);
	        System.out.println("Empty lines:\t\t" + emptyLines);
	        System.out.println("Lines with text:\t" + lines);
	        System.out.println("Lines with page number:\t" + pageIdentifier);
	    }

}
