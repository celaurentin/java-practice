import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracketsTest {

    Brackets b = new Brackets();

    @Test
    void isBalanced() {
        assertFalse(b.isBalanced(""));
        assertFalse(b.isBalanced("(]"));
        assertFalse(b.isBalanced("((([{{}}]))"));
        assertTrue(b.isBalanced("((()))"));
        assertTrue(b.isBalanced("()()[{}]"));
        assertTrue(b.isBalanced("()[]{}"));
    }
}
