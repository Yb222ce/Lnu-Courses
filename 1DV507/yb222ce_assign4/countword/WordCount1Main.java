package yb222ce_assign4.countword;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCount1Main {
public static void main(String[] args) {
		
		try {
	File file = new File("/Users/yetnayetbelachew/eclipse-workspace/java 1/1Dv507/words.txt");
	Scanner scan = new Scanner(file);

	
	HashSet<Word> set = new HashSet<>();
	TreeSet<Word> set2 = new TreeSet<>();
	
	
	while (scan.hasNext()) {
		Word word = new Word(scan.next());
		set.add(word);
		set2.add(word);
	}
	
	System.out.println("Hash words: " + set.size() +" words: "+ set.toString()+ "\n " );
	System.out.println("Tree words: " + set.size() +" words: "+ set2.toString()+ "\n " );
	
	scan.close();
	
	} catch (Exception e) {
		
		e.getStackTrace();
	}
}}
