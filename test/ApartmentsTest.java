import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentsTest {

    Apartments apt = new Apartments();

    @Test
    void getMatches() {
        int[] desired = {60,45,80,75};
        int[] apartments = {70,60,30};

        assertEquals(2, apt.getMatches(apartments, desired, 5));

    }
}
