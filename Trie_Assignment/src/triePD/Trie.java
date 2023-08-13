package triePD;

import java.util.ArrayList;
import java.lang.*;

public class Trie {
	public TrieEntry root;
	
	public static class TrieEntry {
		TrieEntry[] children; 
		public ArrayList<Integer>startOfWordIndex;
		boolean endOfWord;
		
		TrieEntry() {
			children = new TrieEntry[26];
			startOfWordIndex = new ArrayList<Integer>();
			endOfWord = false;
			for (TrieEntry i : children)
				i = null;
		}
		
		public boolean getEndOfWord() {
			return this.endOfWord;
		}
	}
	
	public Trie() {
		root = new TrieEntry();
	}
	
	public void insert(String key, int listIndex) {
        int length = key.length();
        int index = 0;
      
        TrieEntry current = root;
        
        for (int i = 0; i < length; i++) {
            if (key.charAt(i) != '\s' || key.charAt(i) != '\n' || key.charAt(i) != '\t' 
            		|| key.charAt(i) != ',' || key.charAt(i) != '.' || key.charAt(i) != '?' 
            		|| key.charAt(i) != ';' || key.charAt(i) != '‘' || key.charAt(i) != '\'' 
            		|| key.charAt(i) != '\"' || key.charAt(i) != '’' || key.charAt(i) != '('
            		|| key.charAt(i) != ')') {
            
	            index = Character.toLowerCase(key.charAt(i)) - 'a';
	            
	            if (index < 26 && index >= 0) {
		            if (current.children[index] == null)
		                current.children[index] = new TrieEntry();
			      
		            current = current.children[index];
		            } //end if
		        } //end if
        	} //end for
        current.startOfWordIndex.add(listIndex - length);
        current.endOfWord = true;
    }

	public TrieEntry search(String key) {
        int length = key.length();
        int index;
        TrieEntry current = root;
      
        for (int i = 0; i < length; i++)
        {
            index = key.charAt(i) - 'a';
            if (index < 26 && index >= 0)
	            if (current.children[index] == null)
	                return null;
      
            if (index < 26 && index >= 0)
            	current = current.children[index];
        }
        return current;
    }
}
