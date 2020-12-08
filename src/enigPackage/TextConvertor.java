// Group 8: Aaron, Matt, Mike
// TextConvertor Class v_01
// Source: Implementation Details Doc v_01.2

package enigPackage;

import java.util.*;
import java.io.*;

public class TextConvertor {

   /*
   private static String fileTest(String txtFileName) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      File f = new File(txtFileName);
      String inputFile = txtFileName;  
      while(!(f.exists())) {
         System.out.print("File not found. Try again: ");
         inputFile = console.next();
         f = new File(inputFile);   
      }
      
      return inputFile;
      
   }
   */
	public static Queue<Character> convertToQueue(String txtFileName) throws FileNotFoundException {
      Scanner input = new Scanner(new File(txtFileName));      
		Queue<Character> baseText = new LinkedList<Character>();
<<<<<<< HEAD
		String strText = "";
      while (input.hasNext()) {
         strText += input.next();
      }
//		String strText = "cncjpgdbrn";
=======
//		String strText = "Hello World";
		String strText = "oukmdlwuxi";
>>>>>>> 10fddc079abe6cdc480633151a9ecff8229e15ea
		
		for (int i = 0; i < strText.length(); i++) {
			char currChar = strText.toLowerCase().charAt(i);
			if (currChar >= (int) 'a' && currChar <= (int) 'z') {
				baseText.add(currChar);
			}
		}
      return baseText;
	}
}
