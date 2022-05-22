package yb222ce_assign4.countword;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class HashWordSet implements WordSet{
	private Node[] bucket;
	private int size;

	public HashWordSet() { // Constructor
		size = 0;
		bucket = new Node[1];
	}

	private class Node { // Own Node Class as shown in the lecture

		public Word data;
		public Node next;

		public Node(Word word) {
			data = word;
		}
	}

	public void add(Word word) { // Adding a word if it doesn't exist
		
		 if (contains(word)) { 
			 return; }
		 
		 int pos = getBucketIndex(word); // find correct bucket
		 
		 Node node = new Node(word); // Not found, add new node as first entry
		 node.next = bucket[pos]; 
		 bucket[pos] = node;
		 
		 size ++;
		 
		 if (size == bucket.length) { // Rehash if needed 
			 rehash(); 
			 } 
		 }
	
	public boolean contains(Word word) { // inspired by slide numb 17 from
											// hashing lecture

		int pos = getBucketIndex(word); // find correct bucket
		Node node = bucket[pos]; // First node in the list

		while (node != null) { // go through the list and search list for
								// element
			if (node.data.equals(word)) {
				return true; // Word found!!!
			}
			node = node.next; // Next node in list
		}
		return false;
	}

	public int size() {
		return size;
	}
	
	@Override 
	public String toString() { 
		 StringBuilder sb = new StringBuilder(); 
		 Iterator<Word> it = iterator(); 
		 Word wd; // word because of next();
		 while (it.hasNext()) { 
			 wd = it.next(); 
			 sb.append(wd.toString()); 
			 if(it.hasNext()) { 
				 sb.append(", "); 
				 } 
			 } 
		 return sb.toString(); 
		 }
	
	public Iterator<Word> iterator() {
		return new HashIt();
	}
	
	private class HashIt implements Iterator<Word> {

		private int pos;
		private Node node;

		public HashIt() { // Iterator
			node = null;
			pos = -1; // start
		}
		@Override
		public boolean hasNext() {
			if (node != null && node.next != null) {
				return true;
			}

			for (int i = pos + 1; i < bucket.length; i++) {
				if (bucket[i] != null) {
					return true;
				}
			}
			return false;
		}
		
		@Override
		public Word next() {

			if (node == null || node.next == null) {
				// if (current != null) {
				pos++;
				while (bucket[pos] == null && pos < bucket.length) { // check next bucket if empty or not																		
					pos++;
				}
				if (pos < bucket.length) {
					node = bucket[pos];
				} else {
					throw new NoSuchElementException(); // error if no words
				}
			}
			else {
				node = node.next; // jump to next one
			}
			return node.data; // Return dataWord
		}
	}

	private void rehash() { // inspired by slide numb 17 from hashing lecture
		Node[] temp = bucket; // Copy of old buckets
		bucket = new Node[2 * temp.length]; // New empty buckets
		size = 0;
		for (Node nd : temp) { // Insert old values into new buckets
			if (nd == null)
				continue; // Empty bucket
			while (nd != null) {
				add(nd.data); // Add elements again
				nd = nd.next;
			}
		}
	}

	private int getBucketIndex(Word word) { // inspired by slide numb 16 from
		// hashing lecture
		int hc = word.hashCode();
		if (hc < 0) {
			hc = -hc; // Make sure non-negative
		}
		hc = hc % bucket.length;// Simple hash function
		return hc;
	}

}
