package trieUI;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

import triePD.Trie;
import triePD.Trie.TrieEntry;
import trieTest.TrieTest;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Trie_Main_Panel extends JPanel {
	private JTextField searchTextField;
	JTextArea textArea;
	JScrollPane scrollPane;
	Trie trie;
	TrieTest testTrie;

	public Trie_Main_Panel(JPanel contentPane, String text) throws IOException {
		setLayout(null);
		
		testTrie = new TrieTest();
		testTrie.fillTrie();
		trie = testTrie.getTrie();
		
		JLabel lblNewLabel = new JLabel("Search: ");
		lblNewLabel.setBounds(62, 27, 76, 13);
		add(lblNewLabel);
		
		searchTextField = new JTextField();
		searchTextField.setBounds(152, 24, 96, 19);
		searchTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String word = searchTextField.getText();
					word = word.toLowerCase();
					textArea.setText(text);

					// get the highlighter from the textArea
					Highlighter highlighter = textArea.getHighlighter();

					// create a painter with the color
					HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
					
					int wordLength = word.length();
							
					// set a highlight with locations and painter to highlighter
					if(trie.search(word).getEndOfWord()) {
						ArrayList<Integer> indexes = trie.search(word).startOfWordIndex;
				        System.out.println(word + " found at " + indexes.size() + " locations:");
				        for (int i = 0; i < indexes.size(); i++) {
				        	System.out.println("Location " + (i + 1) + ": " + indexes.get(i));
				        	try {
				        		int startLocation = indexes.get(i);
				        		int endLocation = startLocation + wordLength;
							    highlighter.addHighlight(startLocation, endLocation, painter);
				        	}
							
							catch (BadLocationException ex) {}
				        }
					}
				       
					System.out.println();
					//set caret to top of the text area
					textArea.setCaretPosition(0);

				}
			}
		});
		
		add(searchTextField);
		searchTextField.setColumns(10);
		
		textArea = new JTextArea(text);
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(42, 65, 675, 486);
		add(scrollPane);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String word = searchTextField.getText();
				word = word.toLowerCase();
				textArea.setText(text);

				// get the highlighter from the textArea
				Highlighter highlighter = textArea.getHighlighter();

				// create a painter with the color
				HighlightPainter painter = 
				  new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
				
				int wordLength = word.length();
						
				// set a highlight with locations and painter to highlighter
				if(trie.search(word).getEndOfWord()) {
					ArrayList<Integer> indexes = trie.search(word).startOfWordIndex;
			        System.out.println(word + " found at " + indexes.size() + " locations:");
			        for (int i = 0; i < indexes.size(); i++) {
			        	System.out.println("Location " + (i + 1) + ": " + indexes.get(i));
			        	try {
			        		int startLocation = indexes.get(i);
			        		int endLocation = startLocation + wordLength;
						    highlighter.addHighlight(startLocation, endLocation, painter);
			        	}
						
						catch (BadLocationException ex) {}
			        }
				}
			       
				System.out.println();
				//set caret to top of the text area
				textArea.setCaretPosition(0);

			}
		});
		searchButton.setBounds(258, 23, 85, 21);
		add(searchButton);

	}
}
