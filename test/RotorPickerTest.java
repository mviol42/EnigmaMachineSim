import enigPackage.RotorPicker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotorPickerTest {
    @Test
    public void testSetAndGetRotorAmount() {
        RotorPicker rotorPicker = new RotorPicker();
        rotorPicker.setRotorsAmount(1);
        assertEquals(1, rotorPicker.getRotorsAmount());

        rotorPicker.setRotorsAmount(10);
        assertEquals(-1, rotorPicker.getRotorsAmount());
    }
}
