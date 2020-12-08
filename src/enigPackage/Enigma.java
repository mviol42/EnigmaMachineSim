// Group 8: Aaron, Matt, Mike
// Enigma Class v_01
// Source: Implementation Details Doc v_01.2

package enigPackage;

import java.util.*;

public class Enigma {
	private Queue<Character> phrase;
	private RotorList firstRotor;
	private Rotor reflector;
	private Rotor entryWheel;
	
	public Enigma(RotorList chosenRotors, String txtFileName, Rotor reflector, Rotor entryWheel) {
		this.firstRotor = chosenRotors;
		this.phrase = TextConvertor.convertToQueue(txtFileName);
		this.reflector = reflector;
		this.entryWheel = entryWheel;
		System.out.println(this.phrase);
	}
	
	// currently, rather than using the text convertor to write to a txt, encryptor just prints out the cipher.
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
