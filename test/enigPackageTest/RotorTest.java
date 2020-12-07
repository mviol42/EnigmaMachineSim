package enigPackageTest;

import enigPackage.Rotor;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotorTest {
    private Rotor rotor;

    @Before
    public void setup() {
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

        this.rotor = new Rotor (rotorArrList, 0);
    }

    @Test
    public void getAndSetPositionTest() {
        assertEquals(0, rotor.getPosition());
        rotor.setPosition(23);
        assertEquals(23, rotor.getPosition());
        rotor.setPosition(100);
        assertEquals(-1, rotor.getPosition());
    }

    @Test
    public void forwardEncryptCharTest() {

    }
}
