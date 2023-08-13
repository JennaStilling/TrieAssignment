package trieTest;

import java.io.IOException;

import trieDM.TrieDM;
import triePD.Trie;

public class TrieTest {
	Trie trie;
	String textWords;
	int length= 0;
	
	public TrieTest() throws IOException {
		trie = new Trie();
		fillList();
	}
	
	public void testTrie() {
		fillTrie();
		searchTrie();
	}
	
	public void fillTrie() {
		String key = "";
		for (int i = 0; i < textWords.length(); i++) {
            if (textWords.charAt(i) != '\s' && textWords.charAt(i) != '\n' && textWords.charAt(i) != '\t' && textWords.charAt(i) != ',' && textWords.charAt(i) != '.'
            		&& textWords.charAt(i) != '?' && textWords.charAt(i) != ';' && textWords.charAt(i) != '‘' && textWords.charAt(i) != '\'' && textWords.charAt(i) != '\"' && textWords.charAt(i) != '’') {
            	key += textWords.charAt(i);
            }
            else {
    			trie.insert(key, i);
    			key = "";
            }
		}
	}
	
	public void searchTrie() {
		
		//System.out.println("Length: " + length );
		String word = "in";
		System.out.println("Searching for " + word);
		
		if(trie.search(word).getEndOfWord()) {
	        System.out.println("Found, at: ");
	        
	        for (int i = 0; i < trie.search(word).startOfWordIndex.size() -1; i++) {
	        	System.out.println("Location: " + trie.search(word).startOfWordIndex.get(i));
	        }
		}
		
	    else 
	    	System.out.println(word + " not found");
		}
	
	public void fillList() throws IOException {
		TrieDM dm = new TrieDM();
		dm.readFile();
		String text = dm.getText();
		setTextWords(text);
         
		
	}
	
	public void setTextWords(String array) {
		this.textWords = array;
	}
	
	public String getTextWords() {
		return this.textWords;
	}
	
	public Trie getTrie() {
		return trie;
	}
}
