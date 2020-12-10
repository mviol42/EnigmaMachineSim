// Group 8: Aaron, Matt, Mike
// EnigmaK_GUI Class v_01
// Source: Implementation Details Doc v_01.2
// Description: Temporary front end that replicates Enigma K/Enigma G
// EnigmaK_GUI is the front-end of Enigma and handles all interaction with users.
// This class creates the wiring for the rotors, entrywheel, and reflector, replicating the wiring in Enigma model K.
// The class takes the user inputs that defines the order of the rotors as well as their positions,
// along with the position of the reflector. It also takes the name of the .txt file to be encrypted,
// and outputs the ciphertext to the output file whose name is defined by the user.
// https://en.wikipedia.org/wiki/Enigma_rotor_details
// https://www.cryptomuseum.com/crypto/enigma/wiring.htm
// http://www.xat.nl/enigma/manual/5.htm
// http://users.telenet.be/d.rijmenants/en/enigmatech.htm#wiringdiagram
//     These links have specific rotor info.
//
// Wiring used here is based on the wiring of Enigma K.

package enigPackage;

import java.util.*;
import java.io.*;

public class EnigmaK_GUI {
	private static final int ALPHABET_SIZE = 26;
	
	// Initializes the ArrayList<Character> for all of Enigma K’s wheels,
	// takes the user input for the order of the rotors and positions for both the rotors and reflector,
	// takes the user input for both .txt files names (the input file with the phrase and the output file),
	// creates the Enigma object for the given rotors and settings, encrypted the phrase,
	// and outputs the cipher to the new output file.
	public static void main(String[] args) throws FileNotFoundException {
		// For the orders below: 0 = a, etc.
		// ABCDEFGHIJKLMNOPQRSTUVWXYZ 
		//		
		// Rotor I aka 01:
		// LPGSZMHAEOQKVXRFYBUTNICJDW 
		ArrayList<Character> rotorArrList_00 = new ArrayList<Character>()
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
		ArrayList<Character> rotorArrList_01 = new ArrayList<Character>()
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
		ArrayList<Character> rotorArrList_02 = new ArrayList<Character>()
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
		
		// ETW aka Entry Wheel:
		// QWERTZUIOASDFGHJKPYXCVBNML
		ArrayList<Character> ETW = new ArrayList<Character>()
		{{
			add('q'); // a
			add('w'); // b
			add('e'); // c
			add('r'); // d
			add('t'); // e
			add('z'); // f
			add('u'); // g
			add('i'); // h
			add('o'); // i
			add('a'); // j
			add('s'); // k
			add('d'); // l
			add('f'); // m
			add('g'); // n
			add('h'); // o
			add('j'); // p
			add('k'); // q
			add('p'); // r
			add('y'); // s
			add('x'); // t
			add('c'); // u
			add('v'); // v
			add('b'); // w
			add('n'); // x
			add('m'); // y
			add('l'); // z
		}};
		
		// UKW aka Reflector:
		// IMETCGFRAYSQBZXWLHKDVUPOJN 
		ArrayList<Character> UKW = new ArrayList<Character>()
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
		}};
		Rotor reflector = new Rotor(ALPHABET_SIZE, UKW, -1);
		
		RotorPicker rotorPicker = new RotorPicker(ALPHABET_SIZE, allRotors.size());
		rotorPicker.setAllRotors(allRotors);
		Scanner inputter = new Scanner(System.in);
		
//		int looper = -1;
//		while (looper < 0) {
//			System.out.print("Choose the order of the " + allRotors.size() + " rotors: ");
//			if (inputter.hasNextInt()) {
//				rotorPicker.setRotorsAmount(inputter.nextInt());
//			}
//	
//			looper = rotorPicker.getRotorsAmount();
//			if (looper == -1) {
//				System.out.println("Please choose an amount between 1-" + allRotors.size() + ".");
//			}
//		}
		
		int looper = -1;
		String inputFile = "temp";
		String outputFile = "temp";
		PrintStream output;
//		while (looper < 0) {
			System.out.println("Welcome to Enigma.");
	      	System.out.print("Input file name: ");
	      	inputFile = inputter.next();     	
	      	System.out.print("Output file name: ");
	      	outputFile = inputter.next();
	      	
//	      	if (!inputFile.contains(".txt") || !outputFile.contains(".txt")) {
	      		System.out.println("Please only use .txt files.");
//	      	}
//	      	else {
				output = new PrintStream(new File(outputFile));
				looper = 1;
//	      	}
	      	
			System.out.println();
//		}
		
		
		while (reflector.getPosition() < 0) {
			System.out.print("Input the reflector position (1-" + ALPHABET_SIZE + "): ");
			if (inputter.hasNextInt()) {
				reflector.setPosition(inputter.nextInt() - 1);
			}
			
			if (reflector.getPosition() < 0) {
				System.out.println("Please choose a position between 1-" + ALPHABET_SIZE + ".");
			}
		}
		
		Enigma myEnigma = new Enigma(rotorPicker.userRotorSetter(), inputFile, reflector, new Rotor(ALPHABET_SIZE, ETW, 0));
		
		char[] cipher = myEnigma.encryptor();
	    for (char currChar : cipher) {
	    	output.print(currChar);
	    }
	    System.out.println("Printed cipher to " + outputFile);
		inputter.close();
	}
}
