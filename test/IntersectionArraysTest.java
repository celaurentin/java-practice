import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionArraysTest {

    IntersectionArrays ia = new IntersectionArrays();

    @Test
    void getIntersection1() {
        int[] array1 = {1,2,3,4,5,6,7,8,9};
        int[] array2 =  {0,3,4,5,10,11};
        int[] expected = {3,4,5};
        assertArrayEquals(expected, ia.getIntersection1(array1, array2));
    }

    @Test
    void getIntersection2() {
        int[] array1 = {1,2,3,4,5,6,7,8,9};
        int[] array2 =  {0,3,4,5,10,11};
        int[] expected = {3,4,5};
        assertArrayEquals(expected, ia.getIntersection2(array1, array2));
    }
}
