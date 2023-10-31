import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;


class ThriveTest {
    CommonChar t = new CommonChar();

    @Test
    void mostCommonChar() {
        String s1 = "assessment";
        Character expected = 's';
        assertEquals(expected, t.mostCommonChar(s1));
        assertEquals(' ', t.mostCommonChar(""));

    }

    @Test
    void top3CommonChars() {
        String s1 = "assessment";
        List<Character> expected = new ArrayList<>();
        expected.add('s'); expected.add('e'); expected.add('a');
        assertIterableEquals(expected, t.top3CommonChars(s1));
    }
}
