// Group 8: Aaron, Matt, Mike
// RotorPicker Class v_01
// Source: Implementation Details Doc v_01.2

// The RotorPicker class works with the main method in the GUI to determine the rotors used and their
// starting positions in any given run.
package enigPackage;

import java.util.*;

public class RotorPicker {
	private static int ALPHABET_SIZE;
	private int rotorsAmount;
	private ArrayList<ArrayList<Character>> allRotors;
	private RotorList chosenRotors;
	private RotorList firstRotor;

	// Initializes a new rotor picker.
	public RotorPicker(int alphabetSize, int rotorsAmount) {
		ALPHABET_SIZE = alphabetSize;
		this.rotorsAmount = rotorsAmount;
	}

//	// Sets the rotor amount to the given int. If the rotor amount is out of bounds for the number of rotors we have
//	// (hard coded that 0 < n <6), it will set the rotor amount to -1.
//	public void setRotorsAmount(int rotorsAmount) {
//		if (rotorsAmount > 0 && rotorsAmount < 6) {
//			this.rotorsAmount = rotorsAmount;
//		} else {
//			this.rotorsAmount = -1;
//		}
//	}

	// Returns the number of rotors.
	public int getRotorsAmount() {
		return this.rotorsAmount;
	}

	// Sets all the rotors for a given run all at once.
	public void setAllRotors(ArrayList<ArrayList<Character>> allRotors) {
		this.allRotors = allRotors;
	}
	
	// Uses scanner to let the user set their rotors.
	public RotorList userRotorSetter() {
		Scanner inputter = new Scanner(System.in);
		ArrayList<Integer> tempRotorsArr = new ArrayList<Integer>();
		
//		System.out.println("You can choose " + this.rotorsAmount + " rotors out of a selection of 1-" + this.allRotors.size() + ".");
		System.out.println("Choose the order of the " + this.rotorsAmount + " rotors");
		int i = 0;
		while (i < this.rotorsAmount) {
			System.out.print("Choose rotor #" + (i + 1) + ": ");
			int chosenRotor;
			if (inputter.hasNext()) {
				chosenRotor = inputter.nextInt() - 1;
			} else {
				chosenRotor = -1;
			}
			
			if (!tempRotorsArr.contains(chosenRotor)) {
				System.out.print("Choose the start position (1-" + ALPHABET_SIZE + ") for rotor #" + (chosenRotor + 1) + ": ");
				int rotorPos;
				if (inputter.hasNextInt()) {
					rotorPos = inputter.nextInt() - 1;
				} else {
					rotorPos = -1;
				}
				System.out.println();
				
				if ((chosenRotor > -1 && chosenRotor < 5) && (rotorPos > -1 && rotorPos < (ALPHABET_SIZE - 1))) {
					if (i == 0) {
						this.chosenRotors = new RotorList(new Rotor(ALPHABET_SIZE, allRotors.get(chosenRotor), rotorPos));
						this.firstRotor = this.chosenRotors;
					} else {
						this.chosenRotors.addNext(new Rotor(ALPHABET_SIZE, allRotors.get(chosenRotor), rotorPos));
					}
					
					tempRotorsArr.add(chosenRotor);
				} else {
					System.out.println("Please choose a rotor between 1-" + this.allRotors.size() + " with a position 1-" + ALPHABET_SIZE + ".");
				}
				
				i++;
			} else {
				System.out.println("Please do not pick duplicate rotors.");
			}
		}
		
		inputter.close();
		return this.firstRotor;
	}
}
