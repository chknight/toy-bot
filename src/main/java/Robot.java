/**
 *
 */
public class Robot {
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
    Direction currentDirection;

    public Integer getGridX() {
        return gridX;
    }

    public void setGridX(Integer gridX) {
        this.gridX = gridX;
    }

    public Integer getGridY() {
        return gridY;
    }

    public void setGridY(Integer gridY) {
        this.gridY = gridY;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public boolean hasRobotInit() {
        return gridX != null && gridY != null && currentDirection != null;
    }

    /**
     * Change the direction according to the command
     */
    public void changeDirection(Command command) {
        if (command == Command.LEFT || command == Command.RIGHT) {
            currentDirection = PositionUtils.calculateNextDirection(currentDirection, command);
        }
    }

    /**
     * Move after receive the move command
     */
    public void move() {
        gridX = PositionUtils.calculateGridXAfterMove(currentDirection, gridX);
        gridY = PositionUtils.calculateGridYAfterMove(currentDirection, gridY);
    }

    public void updateState(Integer x, Integer y, Direction direction) {
        gridX = x;
        gridY = y;
        currentDirection = direction;
    }
}
