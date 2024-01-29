import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChopTest {

    Chop c = new Chop();

    @Test
    void chop() {
        assertEquals(-1, c.chop(3, new int[]{}));
        assertEquals(-1, c.chop(3, new int[]{1}));
        assertEquals(0, c.chop(1, new int[]{1}));

        assertEquals(0, c.chop(1, new int[]{1, 3, 5}));
        assertEquals(1,  c.chop(3, new int[]{1, 3, 5}));
        assertEquals(2,  c.chop(5, new int[]{1, 3, 5}));
        assertEquals(-1, c.chop(0, new int[]{1, 3, 5}));
        assertEquals(-1, c.chop(2, new int[]{1, 3, 5}));
        assertEquals(-1, c.chop(4, new int[]{1, 3, 5}));

        assertEquals(0,  c.chop(1, new int[]{1, 3, 5, 7}));
        assertEquals(1,  c.chop(3, new int[]{1, 3, 5, 7}));
        assertEquals(2,  c.chop(5, new int[]{1, 3, 5, 7}));
        assertEquals(5,  c.chop(7, new int[]{1, 2, 3, 5, 6, 7, 8}));
        assertEquals(-1, c.chop(0, new int[]{1, 3, 5, 7}));
        assertEquals(-1, c.chop(2, new int[]{1, 3, 5, 7}));
        assertEquals(-1, c.chop(4, new int[]{1, 3, 5, 7}));
        assertEquals(-1, c.chop(6, new int[]{1, 3, 5, 7}));
        assertEquals(-1, c.chop(8, new int[]{1, 3, 5, 7}));
    }
}
