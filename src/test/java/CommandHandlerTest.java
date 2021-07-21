import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(0, robot.getGridX());
        assertEquals(2, robot.getGridY());
        assertEquals(Direction.NORTH, robot.getCurrentDirection());
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
        assertEquals(1, robot.getGridX());
        assertEquals(4, robot.getGridY());
        assertEquals(Direction.WEST, robot.getCurrentDirection());
    }

    @ParameterizedTest()
    @ValueSource(strings = {
            "PLACE 1,2",
            "PLACE 1a,2,NORTH",
            "PLACE 1,2a,NORTH",
            "PLACE 1,2a,N"
    })
    public void shouldThrowExceptionWhenFormatOfPlaceCommandIsWrong(String placeCommand) {
        Exception exception = assertThrows(Exception.class, () -> {
            CommandHandler.handlePlaceCommand(placeCommand, robot);
        });

        String expectedMessage = "PLACE Command is in wrong format, should be PLACE X,Y,F";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @ParameterizedTest()
    @ValueSource(strings = {
            "PLACE -1,2,NORTH",
            "PLACE 5,2,NORTH",
            "PLACE 2,-1,NORTH",
            "PLACE 2,5,NORTH",
    })
    public void shouldThrowExceptionWhenOutOfRange(String placeCommand) {
        Exception exception = assertThrows(Exception.class, () -> {
            CommandHandler.handlePlaceCommand(placeCommand, robot);
        });

        String expectedMessage = "The X and Y in your place command is invalid, they should be >= 0 and <= 4";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void printStatus() {

    }
}
