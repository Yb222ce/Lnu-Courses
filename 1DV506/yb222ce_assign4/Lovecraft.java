package yb222ce_assign4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Lovecraft {
	public static void main(String[] args) throws IOException  {
        int totalLine = 0;
        int emptyLine = 0;
        int pageNumber = 0;

        File file = new File("/Users/yetnayetbelachew/eclipse-workspace/1DV506/src/yb222ce_assign4/lovecraft.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNext()){
            String st = sc.nextLine();

            if (st.equals("")){
                emptyLine ++;
            }
            try{
                Integer.parseInt(st.trim());
                pageNumber ++;
            }
            catch (Exception e){
            }
            totalLine ++;
        }
        sc.close();
        System.out.println("Total lines:            " + totalLine);
        System.out.println("Empty lines:            " + emptyLine);
        System.out.println("Lines with text:        " + (totalLine - emptyLine - pageNumber));
        System.out.println("Lines with page number: " + pageNumber);
    }

}
