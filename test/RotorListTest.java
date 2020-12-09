import enigPackage.Rotor;
import enigPackage.RotorList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotorListTest {
    @Test
    public void testConstructor() {
        ArrayList<Character> rotorArrList = new ArrayList<Character>()
        {{
            add('a');
            add('b');
            add('c');
            add('d');
            add('e');
            add('f');
            add('g');
            add('h');
            add('i');
            add('j');
            add('k');
            add('l');
            add('m');
            add('n');
            add('o');
            add('p');
            add('q');
            add('r');
            add('s');
            add('t');
            add('u');
            add('v');
            add('w');
            add('x');
            add('y');
            add('z');
        }};

        Rotor rotor = new Rotor(rotorArrList, 0);
        RotorList list = new RotorList(rotor);
        assertEquals(rotor, list.rotor);
        assertNull(list.next);
    }

    @Test
    public void testAddNext() {
        ArrayList<Character> rotorArrList0 = new ArrayList<Character>()
        {{
            add('a');
            add('b');
            add('c');
            add('d');
            add('e');
            add('f');
            add('g');
            add('h');
            add('i');
            add('j');
            add('k');
            add('l');
            add('m');
            add('n');
            add('o');
            add('p');
            add('q');
            add('r');
            add('s');
            add('t');
            add('u');
            add('v');
            add('w');
            add('x');
            add('y');
            add('z');
        }};

        Rotor rotor0 = new Rotor(rotorArrList0, 0);
        RotorList list = new RotorList(rotor0);
        list.addNext(rotor0);
        assertEquals(rotor0, list.next.rotor);

        ArrayList<Character> rotorArrList1 = new ArrayList<Character>()
        {{
            add('a');
            add('b');
            add('c');
            add('d');
            add('e');
            add('f');
            add('g');
            add('h');
            add('i');
            add('j');
            add('k');
            add('l');
            add('m');
            add('n');
            add('o');
            add('p');
            add('q');
            add('r');
            add('s');
            add('t');
            add('u');
            add('v');
            add('w');
            add('x');
            add('y');
            add('z');
        }};

        Rotor rotor1 = new Rotor(rotorArrList1, 0);
        list.addNext(rotor1);
        assertEquals(rotor1, list.next.next.rotor);
    }
}
