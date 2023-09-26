import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NathanTest {

    Nathan service = new Nathan();

    @Test
    void nathanSolution() {
        // Test case 1
        String[] T1 = {"test1a", "test2", "test1b", "test1c", "test3"};
        String[] R1 = {"Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded"};

        String[] T2 = {"codility1", "codility3", "codility2", "codility4b", "codility4a"};
        String[] R2 = {"Wrong answer", "OK", "OK", "Runtime error", "OK"};

        assertEquals(service.nathanSolution(T1, R1), 33);
        assertEquals(service.nathanSolution(T2, R2), 50);

    }
}
