package yb222ce_assign2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WarAndPeace {
	public static void main(String[] args) throws IOException {
		String text = readText("/Users/yetnayetbelachew/eclipse-workspace/1DV507/src/yb222ce_assign2/WarAndPeace.txt"); 
		//String[] words = text.split  
													 
		String[] words = text.split(" "); // Simple split
		System.out.println("Initial word count: "+words.length);   // We found 577091
				
		Stream<String> stream = Arrays.stream(words);		
		
		long uniqueWords = stream.flatMap(s -> Stream.of(s.replaceAll("[^a-z'-]+", ""))) //Remove all non-allowed characters				
				.distinct() //Only choose distinct words
				.count(); //Count them
				
		System.out.println("unique words found: " + uniqueWords); //Print out unique word count		
	}

	static String readText(String file) throws IOException {
		List<String> words = Files.readAllLines(Paths.get(file)); //Put the file contents in a list		
		return words.toString().toLowerCase(); 
	}
}

	