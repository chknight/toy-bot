import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PositionUtilsTest {
    @Nested
    class TestChangeDirection {
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
            Direction nextDirection = PositionUtils.calculateNextDirection(currentDirection, command);
            Assertions.assertEquals(expectedNextDirection, nextDirection);
        }

        @ParameterizedTest
        @CsvSource(value = {
                "NORTH,MOVE,NORTH",
                "NORTH,REPORT,NORTH"},
                delimiter = ',')

        void testCalculateDirectionWithWrongCommand(
                Direction currentDirection, Command command, Direction expectedNextDirection) {
            Direction nextDirection = PositionUtils.calculateNextDirection(currentDirection, command);
            Assertions.assertEquals(expectedNextDirection, nextDirection);
        }
    }

    @Nested
    class TestMoveInX {
        @ParameterizedTest
        @CsvSource(value = {
                "NORTH,1,1",
                "SOUTH,1,1"},
                delimiter = ',')

        void shouldNotMoveInXIfDirectionIsToSouthOrNorth(
                Direction currentDirection, Integer currentX, Integer expectedResult) {
            Integer result = PositionUtils.calculateGridXAfterMove(currentDirection, currentX);
            Assertions.assertEquals(expectedResult, result);
        }

        @ParameterizedTest
        @CsvSource(value = {
                "EAST,1,2",
                "EAST,3,4",
                "WEST,1,0",
                "WEST,3,2"},
                delimiter = ',')

        void shouldMoveInXIfDirectionIsToWestAndEastAndMoveIsValid(
                Direction currentDirection, Integer currentX, Integer expectedResult) {
            Integer result = PositionUtils.calculateGridXAfterMove(currentDirection, currentX);
            Assertions.assertEquals(expectedResult, result);
        }

        @ParameterizedTest
        @CsvSource(value = {
                "EAST,4,4",
                "WEST,0,0"},
                delimiter = ',')

        void shouldNotMoveInXIfDirectionIsToWestAndEastAndMoveIsInvalid(
                Direction currentDirection, Integer currentX, Integer expectedResult) {
            Integer result = PositionUtils.calculateGridXAfterMove(currentDirection, currentX);
            Assertions.assertEquals(expectedResult, result);
        }
    }

    @Nested
    class TestMoveInY {
        @ParameterizedTest
        @CsvSource(value = {
                "EAST,1,1",
                "WEST,1,1"},
                delimiter = ',')

        void shouldNotMoveInXIfDirectionIsToEastOrWest(
                Direction currentDirection, Integer currentY, Integer expectedResult) {
            Integer result = PositionUtils.calculateGridYAfterMove(currentDirection, currentY);
            Assertions.assertEquals(expectedResult, result);
        }

        @ParameterizedTest
        @CsvSource(value = {
                "NORTH,1,2",
                "NORTH,3,4",
                "SOUTH,1,0",
                "SOUTH,3,2"},
                delimiter = ',')

        void shouldMoveInXIfDirectionIsToNorthAndSouthAndMoveIsValid(
                Direction currentDirection, Integer currentY, Integer expectedResult) {
            Integer result = PositionUtils.calculateGridYAfterMove(currentDirection, currentY);
            Assertions.assertEquals(expectedResult, result);
        }

        @ParameterizedTest
        @CsvSource(value = {
                "NORTH,4,4",
                "SOUTH,0,0"},
                delimiter = ',')

        void shouldNotMoveInXIfDirectionIsToNorthAndSouthAndMoveIsInvalid(
                Direction currentDirection, Integer currentY, Integer expectedResult) {
            Integer result = PositionUtils.calculateGridYAfterMove(currentDirection, currentY);
            Assertions.assertEquals(expectedResult, result);
        }
    }
}
