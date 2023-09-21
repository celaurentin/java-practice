import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DemolitionRobotTest {
    DemolitionRobot robot = new DemolitionRobot();
    List<List<Integer>> lot = new ArrayList<>();

    @BeforeEach
    void setUp() {
    /*
        Test case:
            Input:
                numRows= 3
                numColumns= 3
            lot=
                [[1, 0, 0],
                 [1, 0, 0],
                 [1, 9, 1]]

        Expected return value: 3
    */

        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        List<Integer> a3 = new ArrayList<>();
        a1.add(1); a1.add(0); a1.add(0);
        a2.add(1); a2.add(0); a2.add(0);
        a3.add(1); a3.add(9); a3.add(1);
        lot.add(a1); lot.add(a2); lot.add(a3);
    }

    @Test
    void removeObstacle() {
        assertEquals(3, robot.removeObstacle(3, 3, lot));
    }
}
