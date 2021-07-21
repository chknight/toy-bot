import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {
    Robot robot;

    @BeforeEach
    public void setup() {
        robot = new Robot();
    }

    @Test
    public void theRobotShouldReturnFalseForIsInit() {
        assertFalse(robot.hasRobotInit());
    }

    @Test
    public void theRobotShouldReturnTrueIfRobotIsInValidState() {
        robot.updateState(2,2, Direction.EAST);
        assertTrue(robot.hasRobotInit());
    }
}
