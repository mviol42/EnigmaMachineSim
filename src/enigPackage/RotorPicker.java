// Group 8: Aaron, Matt, Mike
// RotorPicker Class v_01
// Source: Implementation Details Doc v_01.2

package enigPackage;

import java.util.*;

public class RotorPicker {
	private int rotorsAmount;
	private ArrayList<ArrayList<Character>> allRotors;
	private RotorList chosenRotors;
	private RotorList firstRotor;
	
	public RotorPicker() {
	}
	
	public void setRotorsAmount(int rotorsAmount) {
		if (rotorsAmount > 0 && rotorsAmount < 6) {
			this.rotorsAmount = rotorsAmount;
		}
		else {
			this.rotorsAmount = -1;
		}
	}
	
	public int getRotorsAmount() {
		return this.rotorsAmount;
	}
	
	public void setAllRotors(ArrayList<ArrayList<Character>> allRotors) {
		this.allRotors = allRotors;
	}
	
	// uses scanner to let the user set their rotors.
	public RotorList userRotorSetter() {
		Scanner inputter = new Scanner(System.in);
		ArrayList<Integer> tempRotorsArr = new ArrayList<Integer>();
		
		System.out.println("You can choose " + this.rotorsAmount + " rotors out of a selection of 1-" + this.allRotors.size() + ".");
		int i = 0;
		while (i < this.rotorsAmount) {
			System.out.print("Choose rotor #" + (i + 1) + ": ");
			int chosenRotor;
			if (inputter.hasNext()) {
				chosenRotor = inputter.nextInt() - 1;
			}
			else {
				chosenRotor = -1;
			}
//			System.out.println();
			
			if (!tempRotorsArr.contains(chosenRotor)) {
				System.out.print("Choose the start position (1-26) for rotor #" + (chosenRotor + 1) + ": ");
				int rotorPos;
				if (inputter.hasNextInt()) {
					rotorPos = inputter.nextInt() - 1;
				}
				else {
					rotorPos = -1;
				}
				System.out.println();
				
				if ((chosenRotor > -1 && chosenRotor < 5) && (rotorPos > -1 && rotorPos < 25)) {
					// front of list
					if (i == 0) {
						this.chosenRotors = new RotorList(new Rotor(allRotors.get(chosenRotor), rotorPos));
						this.firstRotor = this.chosenRotors;
					}
					// anywhere else in the list
					else {
						this.chosenRotors.next = new RotorList(new Rotor(allRotors.get(chosenRotor), rotorPos));
						this.chosenRotors.next.previous = this.chosenRotors;
						this.chosenRotors = this.chosenRotors.next;
					}
					
					tempRotorsArr.add(chosenRotor);
				}
				else {
					System.out.println("Please choose a rotor between 1-5 with a position 1-26.");
				}
				
				i++;
			}
			
			else {
				System.out.println("Please do not pick duplicate rotors.");
			}
			
			
		}
		
		inputter.close();
		return this.firstRotor;
	}
}
