import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandHandlerIT {
    Robot robot;

    @BeforeEach
    public void setUp() {
        robot = new Robot();
    }

    @Test
    public void testCommandHandlerWithValidExample1() {
        // Prepare
        List<String> commands = List.of("PLACE 0,0,NORTH", "MOVE", "REPORT");

        // Action
        commands.forEach(command -> CommandHandler.handleCommand(command, robot));

        // Assert
        assertEquals(0, robot.getGridX());
        assertEquals(1, robot.getGridY());
        assertEquals(Direction.NORTH, robot.getCurrentDirection());
    }

    @Test
    public void testCommandHandlerWithValidExample2() {
        // Prepare
        List<String> commands = List.of("PLACE 0,0,NORTH", "LEFT", "REPORT");

        // Action
        commands.forEach(command -> CommandHandler.handleCommand(command, robot));

        // Assert
        assertEquals(0, robot.getGridX());
        assertEquals(0, robot.getGridY());
        assertEquals(Direction.WEST, robot.getCurrentDirection());
    }

    @Test
    public void testCommandHandlerWithValidExample3() {
        // Prepare
        List<String> commands = List.of("PLACE 1,2,EAST", "MOVE", "MOVE", "LEFT", "MOVE", "REPORT");

        // Action
        commands.forEach(command -> CommandHandler.handleCommand(command, robot));

        // Assert
        assertEquals(3, robot.getGridX());
        assertEquals(3, robot.getGridY());
        assertEquals(Direction.NORTH, robot.getCurrentDirection());
    }
}
