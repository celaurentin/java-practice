import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateMatrixTest {

    RotateMatrix rm = new RotateMatrix();

    @Test
    void rotateMatrix() {

        /*
         * 1 2 3         7 4 1
         * 4 5 6    =>   8 5 2
         * 7 8 9         9 6 3
         *
         * 1 2 3   T    1 4 7  R    7 4 1
         * 4 5 6   =>   2 5 8  =>   8 5 2
         * 7 8 9        3 6 9       9 6 3
         */
        int[][] input = { {1,2,3}, {4,5,6}, {7,8,9} };
        int[][] expected = { {7,4,1}, {8,5,2}, {9,6,3} };

        assertArrayEquals(expected, rm.rotateMatrix(input));
    }

    @Test
    void rotateEmptyMatrix() {

        int[][] input = {{}};
        int[][] expected = {{}};;

        assertArrayEquals(expected, rm.rotateMatrix(input));
    }

}
