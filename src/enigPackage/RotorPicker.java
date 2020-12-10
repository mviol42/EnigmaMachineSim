// Group 8: Aaron, Matt, Mike
// RotorPicker Class v_01

// The RotorPicker class works with the main method in the GUI to determine the rotors used and 
// 		their starting positions in any given run.
package enigPackage;

import java.util.*;

public class RotorPicker {
	public final static int ALPHABET_SIZE = 26;
	private int rotorsAmount;
	private ArrayList<ArrayList<Character>> allRotors;
	private RotorList chosenRotors;
	private RotorList firstRotor;

	// Initializes a new rotor picker.
	public RotorPicker(int rotorsAmount) {
		this.rotorsAmount = rotorsAmount;
	}

	// Sets all the rotors for a given run all at once.
	public void setAllRotors(ArrayList<ArrayList<Character>> allRotors) {
		this.allRotors = allRotors;
	}
	
	// Uses scanner to let the user set their rotors.
	public RotorList userRotorSetter() {
		Scanner inputter = new Scanner(System.in);
		ArrayList<Integer> tempRotorsArr = new ArrayList<>();
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
				System.out.print("Choose the start position (1-" + ALPHABET_SIZE + ") for rotor #"
						+ (chosenRotor + 1) + ": ");
				int rotorPos;
				if (inputter.hasNextInt()) {
					rotorPos = inputter.nextInt() - 1;
				} else {
					rotorPos = -1;
				}
				System.out.println();
				
				if ((chosenRotor > -1 && chosenRotor < 5) && (rotorPos > -1 &&
						rotorPos < (ALPHABET_SIZE - 1))) {
					if (i == 0) {
						this.chosenRotors = new RotorList(
								new Rotor(allRotors.get(chosenRotor), rotorPos));
						this.firstRotor = this.chosenRotors;
					} else {
						this.chosenRotors.addNext(new Rotor(allRotors.get(chosenRotor), rotorPos));
					}
					
					tempRotorsArr.add(chosenRotor);
				} else {
					System.out.println("Please choose a rotor between 1-" + this.allRotors.size()
							+ " with a position 1-" + ALPHABET_SIZE + ".");
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
