import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraverseMazeTest {

    TraverseMaze t = new TraverseMaze();

    @Test
    void hasValidPath() {
        int[][] input1 = { {0,0,0}, {0,0,1}, {1,0,0} };
        int[][] input2 = { {0,1,0}, {0,1,1}, {1,0,0} };
        assertTrue(t.hasValidPath(input1, input1.length));
        assertFalse(t.hasValidPath(input2, input2.length));
    }
}
