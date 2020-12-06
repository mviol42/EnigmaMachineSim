// Group 8: Aaron, Matt, Mike
// RotorList Class v_01
// Source: Implementation Details Doc v_01.2

package enigPackage;

public class RotorList {
	public Rotor rotor;
	public RotorList next;
	public RotorList previous;
	
	public RotorList(Rotor rotor) {
		this.rotor = rotor;
		this.next = null;
		this.previous = null;
	}
	
	public void addNext(Rotor nextRotor) {
		RotorList currRotorList = this;
		while (currRotorList.next != null) {
			currRotorList = currRotorList.next;
		}
		
		currRotorList.next = new RotorList(nextRotor);
		currRotorList.next.previous = currRotorList;
	}
}
