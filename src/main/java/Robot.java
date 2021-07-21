/**
 *
 */
public class Robot {
    /**
     *
     */
    Integer maxX;
    Integer minX;
    Integer maxY;
    Integer minY;
    /**
     * Current x of grid point
     */
    Integer gridX;

    /**
     * Current y of grid point
     */
    Integer gridY;

    /**
     * Current Direction the Robot face to
     */
    Direction direction;

    /**
     * Change the direction according to the command
     */
    public void changeDirection(Command command) {
        if (command == Command.LEFT || command == Command.RIGHT) {
            direction = DirectionUtils.calculateNextDirection(direction, command);
        }
    }

    /**
     * Move after receive the move command
     */
    public void move() {
        gridX = DirectionUtils.calculateGridXAfterMove(direction, gridX, minX, maxX);
        gridY = DirectionUtils.calculateGridYAfterMove(direction, gridY, minY, maxY);
    }

    /**
     * Check whether current point is valid
     */
    public Boolean isValid() {
        return gridX <= maxX
                && gridX >= minX
                && gridY <= maxY
                && gridY >= minX;
    }

    public Integer getX() {
        return gridX;
    }

    public Integer getY() {
        return gridY;
    }
}
