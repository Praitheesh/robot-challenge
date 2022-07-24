package robot.challenge.service;

import robot.challenge.model.Position;
import robot.challenge.model.Table;

import java.text.MessageFormat;

public class RobotService {
    /**
     * Print messages in console
     *
     * @param message
     * @param s
     */
    public static void print(String message, String... s) {
        System.out.println(MessageFormat.format(message, (Object[])s));
    }

    /**
     * Validate Robot new position based on Table border
     * @param table
     * @param newPosition
     * @return
     */
    public boolean validateRobotPosition(Table table, Position newPosition) {
        if (table.getMaxX() >= newPosition.getX() && table.getMaxY() >= newPosition.getY()
                && table.getMinX() <= newPosition.getX() && table.getMinY() <= newPosition.getY()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateRobotOccupancy(Table table, Position newPosition) {
        return table.getRobots().size() <= 1 || table.getRobots().values().stream().noneMatch(r -> r.getPosition() != null && r.getPosition().equals(newPosition));
    }
}
