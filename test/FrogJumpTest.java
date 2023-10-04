import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrogJumpTest {

    FrogJump fj = new FrogJump();
    @Test
    void canCross() {
        int[] stones1 = {0, 1, 3, 5, 6, 8, 12, 17};
        int[] stones2 = {0, 1, 2, 3, 4, 8, 9, 11};
        assertTrue(fj.canCross(stones1));
        assertFalse(fj.canCross(stones2));
    }
}
