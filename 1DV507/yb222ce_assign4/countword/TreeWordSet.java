package yb222ce_assign4.countword;

import java.util.Iterator;

public class TreeWordSet implements WordSet {
	//Same as the HashWordSet class, this class is also mostly inspired by the
	
		private BST root; // Create a node class
		private int size;

		public TreeWordSet() { // Constructor
			root = null;
			size = 0;
		}
		
	    @Override
	    public void add(Word word) {
	    	BST bst = new BST(word);
	    	
	        if(root == null) { // the bst will be root if there is no root
	            root = bst;
	            size++;
	        }
	        else {
	            root.addBST(word); // else, going back for more
	        }
	    }

	    @Override
	    public int size() { //Returns size of the set
	        return size;
	    }
	    
	    @Override
	    public boolean contains(Word word) { //Check whether or not a tree contains a word.
	        return root.contains(word);
	    }
	    
	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        Iterator<?> it = iterator();
	        Object next;
	        while(it.hasNext()) {
	        	next = it.next();
	            sb.append(next.toString() + ", ");
	        }
	        return sb.toString();
	    }

	    @SuppressWarnings("unchecked")
		@Override
	    public Iterator<Word> iterator() {
	        return new TreeIt();
	    }

	    @SuppressWarnings("rawtypes")
		private class TreeIt implements Iterator { 
	        BST nw = null;

	        @Override
	        public boolean hasNext() {
	            if(nw == null) {
	                return root != null;
	            }
	            return root.bstSmall(nw.word) != null;
	        }

	        @Override
	        public BST next() { //next element in the iterator
	            if(nw == null) {
	            	nw = root;
	                while(nw.right != null) {
	                	nw = nw.right;
	                }
	                return nw;
	            }
	            nw = root.bstSmall(nw.word);
	            return nw;
	        }
	    }
	    private class BST { //first part from lectures slides page 20 from the lecture about hashing and BST
	        Word word;
	        BST left;   // = null;
	        BST right;   // = null;

	        BST(Word wd) {
	        	word = wd;
	        }
	        public String toString() {
	            return word.toString();
	        }

	        private void addBST(Word wd) {
	            if(word.compareTo(wd) > 0) {
	                if(right == null) {
	                    right = new BST(wd);
	                    size++;
	                }
	                else {
	                    right.addBST(wd);
	                }
	            }

	            if(word.compareTo(wd) < 0) {
	                if(left == null) {
	                    left = new BST(wd);
	                    size++;
	                }
	                else {
	                    left.addBST(wd);
	                }
	            }
	        }
	        private boolean contains(Word wd) {
	            if(word.compareTo(wd) > 0) {
	                if(right == null) {
	                    return false;
	                }
	                else {
	                    return right.contains(wd);
	                }
	            }
	            if(word.compareTo(wd) < 0) {
	                if(left == null) {
	                    return false;
	                }
	                else {
	                    return left.contains(wd);
	                }
	            }
	            return true;
	        }
	        private BST bstSmall(Word wd) {
	            BST node = null;
	            
	            if(right != null) { //recursively to the right
	                node = right.bstSmall(wd);
	            }
	            if(node != null) {
	                return node;
	            }
	            if(wd.compareTo(word) < 0) {
	                return this;
	            }
	            if(left != null) { //recursively to the left
	                node = left.bstSmall(wd);
	            }
	            if(node != null) {
	                return node;
	            }
	            // If none of it matches => the list is empty or it's finished
	            return null;
	        }        }


	   
}
