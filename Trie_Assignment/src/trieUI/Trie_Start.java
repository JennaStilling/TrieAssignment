package trieUI;

import java.io.IOException;

import trieDM.TrieDM;
import trieTest.TrieTest;

public class Trie_Start {
	public static void main(String [] args) throws IOException {
		TrieDM dm = new TrieDM();
		dm.readFile();
		Trie_JFrame frame = new Trie_JFrame(dm.getText());
		try {
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
