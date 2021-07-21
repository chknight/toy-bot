/**
 * Direction
 */
public enum Direction {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private final Integer order;

    Direction(final Integer value) {
        this.order = value;
    }

    /**
     * Get Direction Enum from Value
     * @param value value from 0 - 3
     * @return Direction
     */
    public static Direction fromValue(Integer value) {
        Direction directionFromValue = null;
        for (Direction direction:
             values()) {
            if (direction.order.equals(value)) {
                directionFromValue = direction;
                break;
            }
        }

        return  directionFromValue;
    }

    public Integer getOrder() {
        return this.order;
    }
}
