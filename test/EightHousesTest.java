import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EightHousesTest {

    EightHouses service = new EightHouses();

    @Test
    void cellCompeteCase1() {

        Integer[] states = new Integer[]{1,0,0,0,0,1,0,0};
        int days = 1;
        List<Integer> expected = Arrays.asList(0,1,0,0,1,0,1,0);

        assertEquals(expected, service.cellCompete(states, days));
    }

    @Test
    void cellCompeteCase2() {

        Integer[] states = new Integer[]{1,1,1,0,1,1,1,1};
        int days = 2;
        List<Integer> expected = Arrays.asList(0,0,0,0,0,1,1,0);

        assertEquals(expected, service.cellCompete(states, days));
    }
}
