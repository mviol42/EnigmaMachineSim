import enigPackage.Enigma;
import enigPackage.Rotor;
import enigPackage.RotorList;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EnigmaTest {
    @Test
    public void testEncryptor1() throws FileNotFoundException {
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
        Rotor rotor = new Rotor(rotorArrList0, 0);
        RotorList list = new RotorList(rotor);
        Enigma enigma = new Enigma(list, "test/resources/aab.txt", rotor, rotor);
        char[] output = enigma.encryptor();
        char[] expected = {'a', 'b', 'd'};
        assertArrayEquals(expected, output);
    }

    @Test
    public void testEncryptor2() throws FileNotFoundException {
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
        Rotor rotor = new Rotor(rotorArrList0, 0);
        RotorList list = new RotorList(rotor);
        Enigma enigma = new Enigma(list, "test/resources/zzz.txt", rotor, rotor);
        char[] output = enigma.encryptor();
        char[] expected = {'z', 'a', 'b'};
        assertArrayEquals(expected, output);
    }
}
