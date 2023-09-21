import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    Booking booking = new Booking();

    @Test
    void solutionTest() {
        assertEquals(4, booking.solution(2, "1A 2F 1C"));
        assertEquals(6, booking.solution(2, ""));
        assertEquals(1, booking.solution(1, "1A 1D 1H"));
        assertEquals(0, booking.solution(1, "1A 1D 1G 1H"));
    }
}
