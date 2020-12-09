// Group 8: Aaron, Matt, Mike
// RotorList Class v_01
// Source: Implementation Details Doc v_01.2

// RotorList is a linked list class for Rotors with a next and previous.
package enigPackage;

public class RotorList {
	public Rotor rotor;
	public RotorList next;
	public RotorList previous;

	// Constructs the current RotorList node for the given Rotor rotor,
	// and initializes the next and previous RotorList nodes to null.
	public RotorList(Rotor rotor) {
		this.rotor = rotor;
		this.next = null;
		this.previous = null;
	}

	// Adds a new RotorList node with the given Rotor nextRotor to the end of the linked list.
	// Sets the next and previous RotorList nodes for the new RotorList node.
	public void addNext(Rotor nextRotor) {
		RotorList currRotorList = this;
		while (currRotorList.next != null) {
			currRotorList = currRotorList.next;
		}
		
		currRotorList.next = new RotorList(nextRotor);
		currRotorList.next.previous = currRotorList;
	}
}
