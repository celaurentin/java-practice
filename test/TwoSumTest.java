import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    TwoSum sum = new TwoSum();

    @Test
    void solution() {
        int[] input1 = {2,7,11,15};
        int[] expected1 = {0,1};
        assertArrayEquals(expected1, sum.solution(input1,9));

        int[] input2 = {3,2,4};
        int[] expected2 = {1,2};
        assertArrayEquals(expected2, sum.solution(input2,6));

        int[] input3 = {3,3};
        int[] expected3 = {0,1};
        assertArrayEquals(expected3, sum.solution(input3,6));

    }
}
