// Group 8: Aaron, Matt, Mike
// Enigma Class v_01
// Source: Implementation Details Doc v_01.2

// Enigma takes a given, user-defined set of rotors where the user chooses the order of the three provided rotors that
// were used in the enigma model K. These rotors each have a user-defined position. Enigma takes a .txt file and
// encrypts it with the given rotors, placing the resulting cipher in a new .txt file.
package enigPackage;

import java.util.*;
import java.io.*;

public class Enigma {
	private Queue<Character> phrase;
	private RotorList firstRotor;
	private Rotor reflector;
	private Rotor entryWheel;

	// Creates a new Enigma for the given, user-decided rotors, the name of the .txt file with the  input phrase, and
	// the reflector and entry wheel rotors.
	public Enigma(RotorList chosenRotors, String txtFileName, Rotor reflector, Rotor entryWheel) throws FileNotFoundException {
		this.firstRotor = chosenRotors;
		this.phrase = TextConvertor.convertToQueue(txtFileName);
		this.reflector = reflector;
		this.entryWheel = entryWheel;
		System.out.println(this.phrase);
	}

	// Returns the encrypted cipher from the phrase as a character array. All spaces are removed and the entire array
	// is lowercase.
	// Specifically, this method removes the current character currChar from the queue, runs it through entryWheel,
	// runs it through the recursive helper method which passes the character through the 3 main rotors and reflector,
	// and then runs it back out entryWheel. The character is now encrypted and is added to cipher.
	public char[] encryptor() {
		char[] cipher = new char[this.phrase.size()];
		int counter = 0;
		while (!phrase.isEmpty()) {
//			cipher[counter] = encryptorHelper(this.phrase.remove(), this.firstRotor);

			char currChar = this.entryWheel.forwardEncryptChar(this.phrase.remove());
			currChar = encryptorHelper(currChar, this.firstRotor);
			cipher[counter] =  this.entryWheel.backwardEncryptChar(currChar);
			
			counter++;
		}
		
		return cipher;
	}
	// A helper method for encryptor that recursively passes a character currChar through all the rotors and reflector
	// of a given Enigma and handles rotor position rotations for all 3 main rotors.
	private char encryptorHelper(char currChar, RotorList currRotorList) {
		if (currRotorList.previous == null) {
			System.out.println("rotated first rotor to" + currRotorList.rotor.getPosition());
			currRotorList.rotor.rotate();
		}
		else if (currRotorList.previous.rotor.getPosition() == 0 && currRotorList.previous.rotor.getJustRotated()) {
			System.out.println("other rotor rotated");
			currRotorList.rotor.rotate();
			currRotorList.previous.rotor.setJustRotated(false);
		}
		
		currChar = currRotorList.rotor.forwardEncryptChar(currChar);	
		
		if (currRotorList.next == null) {
			currChar = reflector.forwardEncryptChar(currChar);
		}
		else {
			currChar = encryptorHelper(currChar, currRotorList.next);
		}
		
		currChar = currRotorList.rotor.backwardEncryptChar(currChar);
		return currChar;
	}
}
