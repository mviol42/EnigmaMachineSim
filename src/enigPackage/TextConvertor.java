// Group 8: Aaron, Matt, Mike
// TextConvertor Class v_01

// TextConverter takes a .txt file and converts its contents into a queue that can then be pushed 
//		through the EnigmaK machine.
package enigPackage;

import java.util.*;
import java.io.*;

public class TextConvertor {
	// Takes a .txt file as a parameter, then it scans its contents, and returns a queue 
	// 		containing each letter in the file. All letters are converted to lowercase. Spaces, 
	// 		numbers and symbols are ignored.
	//
	// Throws a FileNotFoundException if the input .txt file does not exist.
	public static Queue<Character> convertToQueue(String txtFileName)
			throws FileNotFoundException {
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
	// This method takes a Scanner as a parameter and asks for the .txt file that the user wants
	// 		to encrypt. If the file does not exist then they will be asked to enter a different 
	//		file. Once a usable file is found then a string of the file name is returned.
	public static String inputFileTest(Scanner input) {
		System.out.print("What is the name of the input file: ");
		String inputFile = input.next();
		File temp = new File(inputFile);
		if (temp.exists()) {
			return inputFile;
		} else {
			System.out.println(inputFile + "does not exist.");
			System.out.println();
			return inputFileTest(input);
		}
	}
}
