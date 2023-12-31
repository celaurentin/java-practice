import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EightHousesTest {

    EightHouses service = new EightHouses();

    @Test
    void cellCompeteCase1() {

        int[] states = new int[]{1,0,0,0,0,1,0,0};
        int days = 1;
        int[] expected = new int[]{0,1,0,0,1,0,1,0};

        assertArrayEquals(expected, service.cellCompete(states, days));
    }

    @Test
    void cellCompeteCase2() {

        int[] states = new int[]{1,1,1,0,1,1,1,1};
        int days = 2;
        int[] expected = new int[]{0,0,0,0,0,1,1,0};

        assertArrayEquals(expected, service.cellCompete(states, days));
    }
}
