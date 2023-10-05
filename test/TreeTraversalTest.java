import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTraversalTest {
    TreeTraversal tt = new TreeTraversal();

    @Test
    void leftSideTest() {
        long[] btree = {3, 6, 2, 9, -1, 10};
        assertEquals("Left", tt.solution(btree));
    }
    @Test
    void rightSideTest() {
        long[] btree = {1, 4, 100, 5};
        assertEquals("Right", tt.solution(btree));
    }
    @Test
    void equalBranchesTest() {
        long[] btree = {1, 10, 5, 1, 0, 6};
        assertEquals("", tt.solution(btree));
    }
    @Test
    void noNodesTest() {
        long[] btree = {};
        assertEquals("", tt.solution(btree));
    }
}
