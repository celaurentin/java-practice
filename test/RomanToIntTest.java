import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntTest {

    RomanToInt r = new RomanToInt();

    @Test
    void toInteger() {
        assertEquals(5, r.toInteger("V"));
        assertEquals(12, r.toInteger("XII"));
        assertEquals(8, r.toInteger("VIII"));
        assertEquals(27, r.toInteger("XXVII"));
        assertEquals(4, r.toInteger("IV"));
        assertEquals(9, r.toInteger("IX"));
        assertEquals(41, r.toInteger("XLI"));
        assertEquals(92, r.toInteger("XCII"));
        assertEquals(403, r.toInteger("CDIII"));
        assertEquals(900, r.toInteger("CM"));
    }
}
