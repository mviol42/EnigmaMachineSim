// Group 8: Aaron, Matt, Mike
// Rotor Class v_01
// Source: Implementation Details Doc v_01.2

package enigPackage;

import java.util.*;

public class Rotor {
	private ArrayList<Character> wiring;
	private int position;
	
	public Rotor(ArrayList<Character> wiring, int position) {
		this.wiring = wiring;
		this.position = position;
	}
	
	public ArrayList<Character> getRotorMap() {
		return this.wiring;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	// Position = -1 if passed position is invalid.
	public void setPosition(int newPosition) {
		if (newPosition > -1 && newPosition < 26) {
			this.position = newPosition;
		}
		else {
			this.position = -1;
		}
	}
	
	public char forwardEncryptChar(char currChar) {
		char encryptedChar = this.wiring.get((int) currChar - ((int) 'a' - this.position));
		return encryptedChar;
	}
	
	public char backwardEncryptChar(char currChar) {
		char encryptedChar = (char) (this.wiring.indexOf(currChar) + ((int) 'a' - this.position));
		return encryptedChar;
	}
	
	public int rotate() {
		this.position++;
		return this.position;
	}
	
}
