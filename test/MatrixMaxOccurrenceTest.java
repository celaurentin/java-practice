import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixMaxOccurrenceTest {

    MatrixMaxOccurrence m = new MatrixMaxOccurrence();
    @Test
    void getMaxOccurrence() {
        int[][] matrix = new int[][] {
                {1,2,3,4,5},
                {2,4,8,9,10},
                {3,5,9,10,18},
                {8,9,16,18,20},
        };

        assertEquals(3, m.getMaxOccurrence(matrix,9));
        assertEquals(2, m.getMaxOccurrence(matrix,5));
        assertEquals(0, m.getMaxOccurrence(matrix,50));
    }
}
