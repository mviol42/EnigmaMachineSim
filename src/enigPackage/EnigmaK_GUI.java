// Group 8: Aaron, Matt, Mike
// EnigmaK_GUI Class
//
// Description: Temporary front end that replicates Enigma K/Enigma G
// 		EnigmaK_GUI is the front-end of Enigma and handles all interaction with users.
// This class creates the wiring for the rotors, entrywheel, and reflector, replicating the wiring
// 		in Enigma model K. The class takes the user inputs that defines the order of the rotors as 
// 		well as their positions, along with the position of the reflector. It also takes the name
// 		of the .txt file to be encrypted,
// 		and outputs the ciphertext to the output file whose name is defined by the user.
//
// These links have specific rotor info:
// https://en.wikipedia.org/wiki/Enigma_rotor_details
// https://www.cryptomuseum.com/crypto/enigma/wiring.htm
// http://www.xat.nl/enigma/manual/5.htm
// http://users.telenet.be/d.rijmenants/en/enigmatech.htm#wiringdiagram
//
// Wiring used here is based on the wiring of Enigma K.

package enigPackage;

import java.util.*;
import java.io.*;

public class EnigmaK_GUI {
	private static final int ALPHABET_SIZE = 26;
	
	// Initializes the ArrayList<Character> for all of Enigma K’s wheels,
	// 		takes the user input for the order of the rotors and positions for both the rotors and
	// 		reflector, takes the user input for both .txt files names (the input file with the
	// 		phrase and the output file),
	// 		creates the Enigma object for the given rotors and settings, encrypted the phrase,
	// 		and outputs the cipher to the new output file.
	//
	// Throws a FileNotFoundException if the input .txt file does not exist.
	public static void main(String[] args) throws FileNotFoundException {
		// For the orders below: 0 = a, etc.
		// ABCDEFGHIJKLMNOPQRSTUVWXYZ 
		//		
		// Rotor I aka 01:
		// LPGSZMHAEOQKVXRFYBUTNICJDW 
		ArrayList<Character> rotorArrList_00 = new ArrayList<>()
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
		ArrayList<Character> rotorArrList_01 = new ArrayList<>()
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
		ArrayList<Character> rotorArrList_02 = new ArrayList<>()
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
		ArrayList<Character> ETW = new ArrayList<>()
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
		ArrayList<Character> UKW = new ArrayList<>()
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

		ArrayList<ArrayList<Character>> allRotors = new ArrayList<>()
		{{
			add(rotorArrList_00);
			add(rotorArrList_01);
			add(rotorArrList_02);
		}};
		Rotor reflector = new Rotor(UKW, -1);
		
		RotorPicker rotorPicker = new RotorPicker(allRotors.size());
		rotorPicker.setAllRotors(allRotors);
		Scanner inputter = new Scanner(System.in);

		System.out.println("Welcome to Enigma.");
		String inputFile = TextConvertor.inputFileTest(inputter);
		System.out.println();
		PrintStream output = new PrintStream(new File("src/resources/output.txt"));

		while (reflector.getPosition() < 0) {
			System.out.print("Input the reflector position (1-" + ALPHABET_SIZE + "): ");
			if (inputter.hasNextInt()) {
				reflector.setPosition(inputter.nextInt() - 1);
			}
			
			if (reflector.getPosition() < 0) {
				System.out.println("Please choose a position between 1-" + ALPHABET_SIZE + ".");
			}
		}
		
		Enigma myEnigma = new Enigma(rotorPicker.userRotorSetter(), inputFile, reflector,
				new Rotor(ETW, 0));

		char[] cipher = myEnigma.encryptor();
	    for (char currChar : cipher) {
	    	output.print(currChar);
	    }
	    System.out.println("Printed cipher to src/resources/output.txt");
		inputter.close();
	}
}
