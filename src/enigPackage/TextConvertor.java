// Group 8: Aaron, Matt, Mike
// TextConvertor Class v_01
// Source: Implementation Details Doc v_01.2

package enigPackage;

import java.util.*;
import java.io.*;

public class TextConvertor {
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
