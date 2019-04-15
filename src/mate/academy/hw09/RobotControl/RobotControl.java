package mate.academy.hw09.RobotControl;

public class RobotControl {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean isSuccessfulAttempt = false;
        for (int i = 0; (i < 3) && (!isSuccessfulAttempt); i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
                isSuccessfulAttempt = true;
            } catch (RobotConnectionException e) {
                if (i == 2) {
                    throw new RobotConnectionException("Connection is lost. Try again!");
                }
            }
            if (isSuccessfulAttempt) {
                break;
            }
        }
    }
}
