package trieUI;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Trie_JFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Trie_JFrame(String text) throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(new Trie_Main_Panel(contentPane, text));
	}
}
