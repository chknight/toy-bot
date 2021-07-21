import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DirectionUtilsTest {
    @ParameterizedTest
    @CsvSource(value = {
            "NORTH,LEFT,WEST",
            "EAST,LEFT,NORTH",
            "SOUTH,LEFT,EAST",
            "WEST,LEFT,SOUTH",
            "NORTH,RIGHT,EAST",
            "EAST,RIGHT,SOUTH",
            "SOUTH,RIGHT,WEST",
            "WEST,RIGHT,NORTH"
            },
            delimiter = ',')

    void testCalculateDirection(
            Direction currentDirection, Command command, Direction expectedNextDirection) {
        Direction nextDirection = DirectionUtils.calculateNextDirection(currentDirection, command);
        Assertions.assertEquals(expectedNextDirection, nextDirection);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "NORTH,MOVE,NORTH",
            "NORTH,REPORT,NORTH"},

            delimiter = ',')

    void testCalculateDirectionWithWrongCommand(
            Direction currentDirection, Command command, Direction expectedNextDirection) {
        Direction nextDirection = DirectionUtils.calculateNextDirection(currentDirection, command);
        Assertions.assertEquals(expectedNextDirection, nextDirection);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "NORTH,1,0,4,1",
            "SOUTH,1,0,4,1"},
            delimiter = ',')

    void shouldNotMoveInXIfDirectionIsToSouthOrNorth(
            Direction currentDirection, Integer currentX, Integer minX, Integer maxX, Integer expectedResult) {
        Integer result = DirectionUtils.calculateGridXAfterMove(currentDirection, currentX, minX, maxX);
        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "EAST,1,0,4,2",
            "EAST,3,0,4,4",
            "WEST,1,0,4,0",
            "WEST,3,0,4,2"},
            delimiter = ',')

    void shouldMoveInXIfDirectionIsToWestAndEastAndMoveIsValid(
            Direction currentDirection, Integer currentX, Integer minX, Integer maxX, Integer expectedResult) {
        Integer result = DirectionUtils.calculateGridXAfterMove(currentDirection, currentX, minX, maxX);
        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "EAST,4,0,4,4",
            "WEST,0,0,4,0"},
            delimiter = ',')

    void shouldNotMoveInXIfDirectionIsToWestAndEastAndMoveIsInvalid(
            Direction currentDirection, Integer currentX, Integer minX, Integer maxX, Integer expectedResult) {
        Integer result = DirectionUtils.calculateGridXAfterMove(currentDirection, currentX, minX, maxX);
        Assertions.assertEquals(expectedResult, result);
    }
}
