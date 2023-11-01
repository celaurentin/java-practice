import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitsTest {

    Digits d = new Digits();

    @Test
    void asArrayTest() {
        char[] expected1 = {'4','5','6'};
        char[] expected2 = {'0'};
        assertArrayEquals(expected1, d.asArray(456));
        assertArrayEquals(expected2, d.asArray(0));
    }
}
