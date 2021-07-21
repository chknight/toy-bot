/**
 * Generic class to calculate next direction according to command
 */
public class PositionUtils {
    final private static int DIRECTION_SIZE = Direction.values().length;
    // TODO The boundary value could be use as input
    /**
     * Max value in X Aris
     */
    final private static int MAX_X = 4;
    /**
     * Min value in X Aris
     */
    final private static int MIN_X = 0;
    /**
     * Max value in Y Aris
     */
    final private static int MAX_Y = 4;
    /**
     * Min value in Y Aris
     */
    final private static int MIN_Y = 0;

    /**
     * Handle the current direction and command and calculate the next command
     * Only Left and Right will be processed, others will be ignored
     * @param currentDirection Current Direction
     * @param command Command to handle
     * @return Direction after handle the command
     */
    public static Direction calculateNextDirection(Direction currentDirection, Command command) {
        Direction nextDirection = currentDirection;
        if (command.equals(Command.LEFT)) {
            nextDirection = Direction.fromValue(( currentDirection.getOrder() - 1 + 4) % DIRECTION_SIZE);
        } else if (command.equals(Command.RIGHT)) {
            nextDirection = Direction.fromValue(( currentDirection.getOrder() + 1) % DIRECTION_SIZE);
        }
        return nextDirection;
    }

    /**
     * Calculate the robot move in x aris
     * @param currentDirection Current direction of robot
     * @param gridX Current Position in X aris
     * @return Return the position in X after moving
     */
    public static Integer calculateGridXAfterMove(
            Direction currentDirection, Integer gridX
    ) {
        return calculatePointAfterMove(currentDirection, gridX, MIN_X, MAX_X, Direction.EAST, Direction.WEST);
    }

    /**
     * Calculate the robot move in y aris
     * @param currentDirection Current direction of robot
     * @param gridY Current Position in y aris
     * @return Return the position in Y after moving
     */
    public static Integer calculateGridYAfterMove(
            Direction currentDirection, Integer gridY
    ) {
        return calculatePointAfterMove(currentDirection, gridY, MIN_Y, MAX_Y, Direction.NORTH, Direction.SOUTH);
    }

    /**
     * Check whether current point is valid
     */
    public static Boolean isValid(int x, int y) {
        return x <= MAX_X
                && x >= MIN_X
                && y <= MAX_Y
                && y >= MIN_Y;
    }

    private static Integer calculatePointAfterMove(
            Direction currentDirection, Integer gridPoint, Integer min, Integer max, Direction directionToIncrease, Direction directionToDecrease) {
        int move = 0;
        int afterMove = gridPoint;
        if (currentDirection == directionToIncrease) {
            move = 1;
        } else if (currentDirection == directionToDecrease) {
            move = -1;
        }
        if (isValidMove( gridPoint, move, min, max)) {
            afterMove += move;
        }
        return afterMove;
    }

    private static Boolean isValidMove(Integer gridPoint, Integer move, Integer min, Integer max) {
        int afterMove = gridPoint + move;
        return afterMove >= min && afterMove <= max;
    }
}
