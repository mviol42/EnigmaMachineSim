// Group 8: Aaron, Matt, Mike
// TextConvertor Class v_01
// Source: Implementation Details Doc v_01.2

package enigPackage;

import java.util.*;

public class TextConvertor {
	
	// TEMP METHOD
	// This method is temporary to give us a queue for testing. 
	public static Queue<Character> convertToQueue(String txtFileName) {
		Queue<Character> baseText = new LinkedList<Character>();
		String strText = "Hello World";
		
		for (int i = 0; i < strText.length(); i++) {
			char currChar = strText.toLowerCase().charAt(i);
			if (currChar > 96 && currChar < 123) {
				baseText.add(currChar);
			}
		}
		
		return baseText;
	}
}
