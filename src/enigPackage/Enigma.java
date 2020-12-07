// Group 8: Aaron, Matt, Mike
// Enigma Class v_01
// Source: Implementation Details Doc v_01.2

package enigPackage;

import java.util.*;

public class Enigma {
	private Queue<Character> phrase;
	private RotorList firstRotor;
	
	public Enigma(RotorList chosenRotors, String txtFileName) {
		this.firstRotor = chosenRotors;
		this.phrase = TextConvertor.convertToQueue(txtFileName);
		System.out.println(this.phrase);
	}
	
	// currently, rather than using the text convertor to write to a txt, encryptor just prints out the cipher.
	public char[] encryptor() {
		char[] cipher = new char[this.phrase.size()];
		int counter = 0;
		while (!phrase.isEmpty()) {
			cipher[counter] = encryptorHelper(this.phrase.remove(), this.firstRotor);
			counter++;
		}
		
		return cipher;
	}
	
	private char encryptorHelper(char currChar, RotorList currRotorList) {
		currChar = currRotorList.rotor.forwardEncryptChar(currChar);	
		
		if (currRotorList.previous == null) {
			currRotorList.rotor.rotate();
		}
		else if (currRotorList.previous.rotor.getPosition() == 0) {
			if (currRotorList.previous.previous == null) {
				currRotorList.rotor.rotate();
			}
			else if (currRotorList.previous.previous.rotor.getPosition() == 1) {
				currRotorList.rotor.rotate();
			}
		}
		
		if (currRotorList.next == null) {
		}
		else {
			currChar = encryptorHelper(currChar, currRotorList.next);
		}
		
		currChar = currRotorList.rotor.backwardEncryptChar(currChar);
		return currChar;
	}
}
