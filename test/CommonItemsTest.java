import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CommonItemsTest {

    CommonItems ci = new CommonItems();

    @Test
    void getCommonItems() {
        Integer[] A = {1,2,3,4,5,6,7,8};
        Integer[] B = {3,4,5,10,11,12};

        Set<Integer> expected = new HashSet<>();
        expected.add(3); expected.add(4); expected.add(5);
        assertEquals(expected, ci.getCommonItems(A, B));

    }

    @Test
    void getNonCommonItems() {
        Integer[] A = {1,2,3,4,5,6,7,8};
        Integer[] B = {3,4,5,10,11,12};

        Set<Integer> expected = new HashSet<>();
        expected.add(1); expected.add(2); expected.add(6); expected.add(7); expected.add(8);
        expected.add(10); expected.add(11); expected.add(12);
        assertEquals(expected, ci.getNonCommonItems(A, B));

    }


}
