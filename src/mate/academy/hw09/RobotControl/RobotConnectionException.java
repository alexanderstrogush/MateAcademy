package mate.academy.hw09.RobotControl;

public class RobotConnectionException extends RuntimeException {

    public RobotConnectionException(String message) {
        super(message);
    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}