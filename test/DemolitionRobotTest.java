import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemolitionRobotTest {
    DemolitionRobot robot = new DemolitionRobot();
    int[][] lot = {
                {1,0,0},
                {1,0,0},
                {1,9,1}
            };

    @Test
    void removeObstacle() {
        assertEquals(3, robot.removeObstacle(3, 3, lot));
    }
}
