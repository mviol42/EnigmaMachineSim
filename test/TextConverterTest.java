import enigPackage.TextConvertor;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextConverterTest {
    public static Queue<Character> setup() {
        Queue<Character> expected = new LinkedList<>();
        expected.add('t');
        expected.add('e');
        expected.add('s');
        expected.add('t');
        return expected;
    }

    @Test
    public void testLowercase() throws FileNotFoundException {
        Queue<Character> output = TextConvertor.convertToQueue("test/resources/lowercase.txt");
        Queue<Character> expected = setup();
        assertEquals(expected, output);
    }

    @Test
    public void testUppercase() throws FileNotFoundException {
        Queue<Character> output = TextConvertor.convertToQueue("test/resources/uppercase.txt");
        Queue<Character> expected = setup();
        assertEquals(expected, output);
    }

    @Test
    public void testNumbers() throws FileNotFoundException {
        Queue<Character> output = TextConvertor.convertToQueue("test/resources/numbers.txt");
        Queue<Character> expected = setup();
        assertEquals(expected, output);
    }
    @Test
    public void testSpace() throws FileNotFoundException {
        Queue<Character> output = TextConvertor.convertToQueue("test/resources/space.txt");
        Queue<Character> expected = setup();
        assertEquals(expected, output);
    }
    @Test
    public void testSymbols() throws FileNotFoundException {
        Queue<Character> output = TextConvertor.convertToQueue("test/resources/symbols.txt");
        Queue<Character> expected = setup();
        assertEquals(expected, output);
    }
}
