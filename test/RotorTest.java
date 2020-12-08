import enigPackage.Rotor;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotorTest {

    @Test
    public void getAndSetPositionTest() {
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

        Rotor rotor = new Rotor (rotorArrList, 0);
        assertEquals(0, rotor.getPosition());
        rotor.setPosition(23);
        assertEquals(23, rotor.getPosition());
        rotor.setPosition(100);
        assertEquals(-1, rotor.getPosition());
    }

    @Test
    public void forwardEncryptCharTest() {
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

        Rotor rotor = new Rotor (rotorArrList, 0);

        assertEquals('a', rotor.forwardEncryptChar('a'));
        assertEquals('z', rotor.forwardEncryptChar('z'));

        rotor.setPosition(1);

        assertEquals('b', rotor.forwardEncryptChar('a'));
        assertEquals('z', rotor.forwardEncryptChar('y'));
        assertEquals('a', rotor.forwardEncryptChar('z'));
    }

    @Test
    public void rotateTest() {
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

        Rotor rotor = new Rotor (rotorArrList, 0);

        assertEquals(1, rotor.rotate());
        assertEquals(2, rotor.rotate());

        rotor.setPosition(25);

        assertEquals(0, rotor.rotate());
    }

    @Test
    public void backwardBasicTest() {
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

        Rotor rotor = new Rotor (rotorArrList, 0);
        assertEquals('a', rotor.backwardEncryptChar('a'));

        rotor.setPosition(1);
        assertEquals('a', rotor.backwardEncryptChar('b'));
        assertEquals('b', rotor.backwardEncryptChar('c'));

        rotor.setPosition(2);
        assertEquals('a', rotor.backwardEncryptChar('c'));
        assertEquals('b', rotor.backwardEncryptChar('d'));
    }

    @Test
    public void backwardsEdgeCaseTest() {
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

        Rotor rotor = new Rotor (rotorArrList, 1);
        assertEquals('z', rotor.backwardEncryptChar('a'));
    }

    @Test
    public void backwardsTwoRotorTest() {
        ArrayList<Character> rotorArrList_0 = new ArrayList<Character>()
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

        ArrayList<Character> rotorArrList_1 = new ArrayList<Character>()
        {{
            add('c');
            add('j');
            add('g');
            add('d');
            add('p');
            add('s');
            add('h');
            add('k');
            add('t');
            add('u');
            add('r');
            add('a');
            add('w');
            add('z');
            add('x');
            add('f');
            add('m');
            add('y');
            add('n');
            add('q');
            add('o');
            add('b');
            add('v');
            add('l');
            add('i');
            add('e');
        }};

        Rotor rotor0 = new Rotor (rotorArrList_0, 0);
        Rotor rotor1 = new Rotor (rotorArrList_1, 0);

        char throughR1 = rotor1.backwardEncryptChar('c');
        assertEquals('a', rotor0.backwardEncryptChar(throughR1));
    }
}
