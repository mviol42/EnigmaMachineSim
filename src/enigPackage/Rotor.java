// Group 8: Aaron, Matt, Mike
// Rotor Class v_01

// Rotor takes a given list that represents the internal wiring for the Rotor and a user-defined 
// 		position. Each rotor in Enigma can rotate, but does so differently depending on where the 
//		given rotor is located in the order of rotors in Enigma. At its most basic, Enigma has a 
//		fast, medium, and slow rotor. The fast rotor, the first in the order, rotates on each key 
//		press. The medium rotor rotates when the fast rotor reach its turnover position, and the 
// 		slow rotor rotates when the medium rotor reaches its turnover position. The Rotor class 
//		also handles the encryption of the current letter, passing the letter either forward or 
//		backward through the Rotor's wiring (depending on where in Enigma's circuit 
// 		the letter currently is).

package enigPackage;

import java.util.*;

public class Rotor {
	public static final int ALPHABET_SIZE = 26;
	private ArrayList<Character> wiring;
	private int position;
	private boolean justRotated;

	// Constructs a Rotor for the giving wiring and position. justRotated defaults to false
	public Rotor(ArrayList<Character> wiring, int position) {
		this.wiring = wiring;
		this.position = position;
		this.justRotated = false;
	}

	// Returns position.
	public int getPosition() {
		return this.position;
	}
	
	// Sets the position given a new position. If the inputted position goes above ALPHABET_SIZE,
	// 		the method sets the position to 0 (representing the circular rotor reaching a zero 
	//		offset). if an invalid position is entered, it is set to -1
	public void setPosition(int newPosition) {
		if (newPosition > -1 && newPosition < ALPHABET_SIZE) {
			this.position = newPosition;
		} else {
			this.position = -1;
		}
	}

	// Forward encrypts the given character currChar by setting integer
	// 		adjustedPos to the index value of currChar plus position
	// 		(subtracts ascii values from currChar to have a letter in a
	// 		indexed alphabet where ‘a’ has an index of 0)
	// 		and sending the resulting adjustedPos through ArrayList wiring.
	public char forwardEncryptChar(char currChar) {
		int adjustedPos = ((int) currChar - (int) 'a') + this.position;
		char encryptedChar;
		
		if (adjustedPos < ALPHABET_SIZE) {
			encryptedChar = this.wiring.get(adjustedPos);
		} else {
			encryptedChar = this.wiring.get(adjustedPos - ALPHABET_SIZE);
		}
		
		return encryptedChar;
	}

	// Backward encrypts the given character currChar by subtracting position from the
	// 		index of the current character in ArrayList wiring and sending the resulting
	// 		integer adjustedPos through wiring.
	public char backwardEncryptChar(char currChar) {
		int adjustedPos = this.wiring.indexOf(currChar) - this.position;
		char encryptedChar;
		
		if (adjustedPos < 0) {
			encryptedChar = (char) (adjustedPos + (int) 'a' + ALPHABET_SIZE);
		} else {
			encryptedChar = (char) (adjustedPos + (int) 'a');
		}
		
		this.justRotated = true;
		return encryptedChar;
	}

	// Rotates the rotor by increasing position by 1. If the resulting position exceeds
	// 		ALPHABET_SIZE - 1 (representing ALPHABET_SIZE where 'a' is at index 0), the 
	//		method sets the position to 0.
	//		ALso sets boolean justRotated to true.
	public int rotate() {
		if (this.position < (ALPHABET_SIZE - 1)) {
			this.position++;
		} else {
			this.position = 0;
		}
		
		this.justRotated = true;
		return this.position;
	}

	// Sets justRotated to the given boolean rotationState.
	public void setJustRotated(boolean rotationState) {
		this.justRotated = rotationState;
	}

	// Returns justRotated.
	public boolean getJustRotated() {
		return this.justRotated;
	}
}
