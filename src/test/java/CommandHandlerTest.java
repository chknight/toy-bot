import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandHandlerTest {
    Robot robot;

    @BeforeEach
    public void setUp() {
        robot = new Robot();
    }

    @Test
    void shouldParsePlaceCommandCorrectly() throws Exception{
        // Prepare
        String placeCommand = "PLACE 0,2,NORTH";

        // Action
        CommandHandler.handlePlaceCommand(placeCommand, robot);

        //Assert
        Assertions.assertEquals(0, robot.getGridX());
        Assertions.assertEquals(2, robot.getGridY());
        Assertions.assertEquals(Direction.NORTH, robot.getCurrentDirection());
    }

    @Test
    void shouldParsePlaceCommandCorrectlyAndUpdateExistingRobot() throws Exception{
        // Prepare
        String placeCommand = "PLACE 1,4,WEST";
        robot.setGridX(2);
        robot.setGridY(3);
        robot.setCurrentDirection(Direction.EAST);

        // Action
        CommandHandler.handlePlaceCommand(placeCommand, robot);

        //Assert
        Assertions.assertEquals(1, robot.getGridX());
        Assertions.assertEquals(4, robot.getGridY());
        Assertions.assertEquals(Direction.WEST, robot.getCurrentDirection());
    }
}
