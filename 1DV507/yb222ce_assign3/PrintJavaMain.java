package yb222ce_assign3;

import java.io.File;
import java.io.FileNotFoundException;

public class PrintJavaMain {
	public static void main(String[] args) throws FileNotFoundException {

        File startDir = new File("/Users/yetnayetbelachew/eclipse-workspace/1DV507/src/yb222ce_assign3");
        if (startDir.exists())
            System.out.println("Start: " + startDir);
        else
            System.out.println("Can't find directory: " + startDir);
        visitSub(startDir);
    }


    private static void visitSub(File filetDir) {
        if (filetDir.isDirectory()) {
            File[] subs = filetDir.listFiles();
            for (File f : subs) {
                visitSub(f);
            }
        } else {
            if (filetDir.getName().endsWith(".java")) { //print all java files name//
                printDir(filetDir);
            }
        }
    }

    private static void printDir(File file) {
        System.out.println(file.getName() + " Size of file " + file.length() + " the number of rows is");
    }

}
