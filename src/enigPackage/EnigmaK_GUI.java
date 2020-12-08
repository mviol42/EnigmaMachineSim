// Group 8: Aaron, Matt, Mike
// EnigmaK_GUI Class v_01
// Source: Implementation Details Doc v_01.2
// Description: Temporary front end that replicates Enigma K/Enigma G

package enigPackage;

import java.util.*;
import java.io.*;

public class EnigmaK_GUI {
	// https://en.wikipedia.org/wiki/Enigma_rotor_details
	// https://www.cryptomuseum.com/crypto/enigma/wiring.htm
	//     These links has specific rotor info.
	//
	// Wiring used here is based on the wiring of Enigma K.
	public static void main(String[] args) throws FileNotFoundException {
		// For the orders below: 0 = a, etc.
		// ABCDEFGHIJKLMNOPQRSTUVWXYZ 
		//
		// Rotor ETW aka 00:
		// QWERTZUIOASDFGHJKPYXCVBNML
		ArrayList<Character> rotorArrList_00 = new ArrayList<Character>()
		{{
			add('q');
			add('w');
			add('e');
			add('r');
			add('t');
			add('z');
			add('u');
			add('i');
			add('o');
			add('a');
			add('s');
			add('d');
			add('f');
			add('g');
			add('h');
			add('j');
			add('k');
			add('p');
			add('y');
			add('x');
			add('c');
			add('v');
			add('b');
			add('n');
			add('m');
			add('l');
		}};
		
		// Rotor I aka 01:
		// LPGSZMHAEOQKVXRFYBUTNICJDW 
		ArrayList<Character> rotorArrList_01 = new ArrayList<Character>()
		{{
			add('l');
			add('p');
			add('g');
			add('s');
			add('z');
			add('m');
			add('h');
			add('a');
			add('e');
			add('o');
			add('q');
			add('k');
			add('v');
			add('x');
			add('r');
			add('f');
			add('y');
			add('b');
			add('u');
			add('t');
			add('n');
			add('i');
			add('c');
			add('j');
			add('d');
			add('w');
		}};
		
		// Rotor II aka 02:
		// SLVGBTFXJQOHEWIRZYAMKPCNDU  
		ArrayList<Character> rotorArrList_02 = new ArrayList<Character>()
		{{
			add('s');
			add('l');
			add('v');
			add('g');
			add('b');
			add('t');
			add('f');
			add('x');
			add('j');
			add('q');
			add('o');
			add('h');
			add('e');
			add('w');
			add('i');
			add('r');
			add('z');
			add('y');
			add('a');
			add('m');
			add('k');
			add('p');
			add('c');
			add('n');
			add('d');
			add('u');
		}};

		// Rotor III aka 03:
		// CJGDPSHKTURAWZXFMYNQOBVLIE 
		ArrayList<Character> rotorArrList_03 = new ArrayList<Character>()
		{{
			add('c');
			add('j');
			add('g');
			add('d');
			add('p');
			add('s');
			add('h');
			add('k');
			add('t');
			add('u');
			add('r');
			add('a');
			add('w');
			add('z');
			add('x');
			add('f');
			add('m');
			add('y');
			add('n');
			add('q');
			add('o');
			add('b');
			add('v');
			add('l');
			add('i');
			add('e');
		}};
		
		// Rotor UKW aka 04:
		// IMETCGFRAYSQBZXWLHKDVUPOJN 
		ArrayList<Character> rotorArrList_04 = new ArrayList<Character>()
		{{
			add('i');
			add('m');
			add('e');
			add('t');
			add('c');
			add('g');
			add('f');
			add('r');
			add('a');
			add('y');
			add('s');
			add('q');
			add('b');
			add('z');
			add('x');
			add('w');
			add('l');
			add('h');
			add('k');
			add('d');
			add('v');
			add('u');
			add('p');
			add('o');
			add('j');
			add('n');
		}};

		ArrayList<ArrayList<Character>> allRotors = new ArrayList<ArrayList<Character>>()
		{{
			add(rotorArrList_00);
			add(rotorArrList_01);
			add(rotorArrList_02);
			add(rotorArrList_03);
			add(rotorArrList_04);
		}};
		
		RotorPicker rotorPicker = new RotorPicker();
		rotorPicker.setAllRotors(allRotors);
		Scanner inputter = new Scanner(System.in);
		
		int looper = -1;
		while (looper < 0) {
			System.out.print("How many rotors are we using out of " + allRotors.size() + " (3 recommended): ");
			if (inputter.hasNextInt()) {
				rotorPicker.setRotorsAmount(inputter.nextInt());
			}
	
			looper = rotorPicker.getRotorsAmount();
			if (looper == -1) {
				System.out.println("Please choose an amount between 1-" + allRotors.size() + ".");
			}
		}
		
		System.out.println();
      System.out.print("Input file name: ");
      String inputFile = inputter.next();
      System.out.println();
      System.out.print("output file name: ");
      String outputFile = inputter.next();
		PrintStream output = new PrintStream(new File(outputFile));
		Enigma myEnigma = new Enigma(rotorPicker.userRotorSetter(), inputFile);
		System.out.println("Printing: ");
		char[] cipher = myEnigma.encryptor();
      for (char currChar : cipher) {
			output.print(currChar);
		}
      System.out.println("Printed cipher to " + outputFile);
		inputter.close();
	}
}
