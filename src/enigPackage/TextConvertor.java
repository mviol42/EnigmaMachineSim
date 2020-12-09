// Group 8: Aaron, Matt, Mike
// TextConvertor Class v_01
// Source: Implementation Details Doc v_01.2

// TextConverter takes a .txt file and converts its contents into a queue that can then be pushed through the
// EnigmaK machine.
package enigPackage;

import java.util.*;
import java.io.*;

public class TextConvertor {
	// Takes a .txt file as a parameter, scans its contents, and returns a queue containing each letter in the file.
	// All letters are changed to lowercase and spaces, symbols, and numbers are ignored.
	public static Queue<Character> convertToQueue(String txtFileName) throws FileNotFoundException {
		Scanner input = new Scanner(new File(txtFileName));
		Queue<Character> baseText = new LinkedList<>();
		String strText = "";
      	while (input.hasNext()) {
         	strText += input.next();
      	}
		
		for (int i = 0; i < strText.length(); i++) {
			char currChar = strText.toLowerCase().charAt(i);
			if (currChar >= (int) 'a' && currChar <= (int) 'z') {
				baseText.add(currChar);
			}
		}
		return baseText;
	}
}
