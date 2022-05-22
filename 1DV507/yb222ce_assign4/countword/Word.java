package yb222ce_assign4.countword;

public class Word implements Comparable<Word> {
	private String word;

	public Word(String str) {
		this.word = str.toLowerCase();
	}

	public String toString() {
		return word;
	}

	// Override Object methods
	public int hashCode() { 
		return word.hashCode();    // compute a hash value for word 
    }

	public boolean equals(Object other) { 
		if (other instanceof Word) {
            Word w = (Word)other;		
            return (w.word.equalsIgnoreCase(word));   // true if two words are equal
        }
        else {
            return false;
        }
    }

	// Implement Comparable 
	public int compareTo(Word w) { 
		return this.word.compareTo(w.word); // compares two words lexicographically 
	}

}
