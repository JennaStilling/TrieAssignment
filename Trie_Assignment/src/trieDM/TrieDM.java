package trieDM;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TrieDM {
	String text;
	
	public TrieDM() {
		text = "";
	}
	
	public void readFile() throws IOException {
		File file = new File("src\\john1.txt");
	    try {
	        String line;
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        while((line = reader.readLine()) != null) {
	        	text += line + "\n";
	        }
	        
	        reader.close();
        }
	    
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	}
	
	public String getText() {
		return this.text;
	}
}
