public class CommandHandler {
    public static boolean handleCommand(String userInput, Robot robot) {
        try {
            if (userInput.startsWith("PLACE")) {
                handlePlaceCommand(userInput, robot);
                return true;
            } else if (robot.hasRobotInit())  {
                throw new Exception("Need to place a valid place command before continuing");
            }
            Command command = Command.valueOf(userInput);
            // Robot is in valid position, ignore the command
            switch (command) {
                case LEFT:
                case RIGHT:
                    robot.changeDirection(command);
                    break;
                case MOVE:
                    robot.move();
                    break;
                case REPORT:
                    printRobotState(robot);
                    break;
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("Your input is not a valid input, please provide input with value PLACE/LEFT/RIGHT/MOVE/REPORT");
            return false;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Handle the place ment comment
     * @param placeCommand Command to place the robot
     * @param robot Current Robot
     * @throws Exception Exception when parsing the place command
     */
    public static void handlePlaceCommand(String placeCommand, Robot robot) throws Exception {
        String positionInfo = placeCommand.replaceFirst("PLACE ", "");
        String[] positions = positionInfo.split(",");
        if (positions.length != 3) {
            throw new Exception("PLACE Command is in wrong format, should be PLACE X,Y,F");
        }
        try {
            int gridX = Integer.parseInt(positions[0]);
            int gridY = Integer.parseInt(positions[1]);
            Direction direction = Direction.valueOf(positions[2]);

            if (PositionUtils.isValid(gridX, gridY)) {
                robot.updateState(gridX, gridY, direction);
            } else {
                throw new Exception("The X and Y in your place command is invalid, they should be >= 0 and <= 4");
            }
        } catch (IllegalArgumentException exception) {
            throw new Exception("PLACE Command is in wrong format, should be PLACE X,Y,F");
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static void printRobotState(Robot robot) {
        String message = String.format("Robot is in grid with X: %d, Y: %d, Direction: %s", robot.getGridX(), robot.getGridY(), robot.getCurrentDirection());
        System.out.println(message);
    }
}
