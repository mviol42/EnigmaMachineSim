// Group 8: Aaron, Matt, Mike
// Rotor Class v_01
// Source: Implementation Details Doc v_01.2

package enigPackage;

import java.util.*;

public class Rotor {
	private ArrayList<Character> wiring;
	private int position;
	private boolean justRotated;
	
	public Rotor(ArrayList<Character> wiring, int position) {
		this.wiring = wiring;
		this.position = position;
		this.justRotated = false;
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
//		System.out.println("a: " + (int) 'a');
//		System.out.println("position: " + this.position);
//		System.out.println("a - position: " + ((int) 'a' - this.position));
//		System.out.println("currChar: " + currChar);
//		System.out.println((int) currChar - ((int) 'a' - this.position));
//		System.out.println("new maths: " + (((int) currChar - (int) 'a') + this.position));
		int adjustedPos = ((int) currChar - (int) 'a') + this.position;
		char encryptedChar;
		
		if (adjustedPos < 26) {
			encryptedChar = this.wiring.get(adjustedPos);
		}
		else {
			encryptedChar = this.wiring.get(adjustedPos - 26);
		}
		
		return encryptedChar;
	}
	
	public char backwardEncryptChar(char currChar) {
//		char encryptedChar = (char) (this.wiring.indexOf(currChar) + ((int) 'a' + this.position));
		int adjustedPos = this.wiring.indexOf(currChar) - this.position;
		char encryptedChar;
		
		if (adjustedPos < 0) {
			encryptedChar = (char) (adjustedPos + (int) 'a' + 26);
		}
		else {
			encryptedChar = (char) (adjustedPos + (int) 'a');
		}
		
		this.justRotated = true;
		return encryptedChar;
	}
	
	public int rotate() {
		if (this.position < 25) {
			this.position++;
		}
		else {
			this.position = 0;
		}
		
		this.justRotated = true;
		return this.position;
	}
	
	public void setJustRotated(boolean rotationState) {
		this.justRotated = rotationState;
	}
	
	public boolean getJustRotated() {
		return this.justRotated;
	}
	
}
