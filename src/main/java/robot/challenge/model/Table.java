package robot.challenge.model;

import robot.challenge.util.Constants;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private int activeRobotId = 1;
    private Map<Integer, Robot> robots = new HashMap<>();;
    private int TABLE_MAX_SIZE_Y = Constants.TABLE_MAX_Y_SIZE;
    private int TABLE_MAX_SIZE_X = Constants.TABLE_MAX_X_SIZE;
    private int TABLE_MIN_SIZE_Y = Constants.TABLE_MIN_Y_SIZE;
    private int TABLE_MIN_SIZE_X = Constants.TABLE_MIN_X_SIZE;

    public Table() {}

    public Table(int maxX, int maxY) {
        this.TABLE_MAX_SIZE_X = maxX;
        this.TABLE_MAX_SIZE_Y = maxY;
    }

    public int getMaxX() {
        return TABLE_MAX_SIZE_X;
    }

    public int getMaxY() {
        return TABLE_MAX_SIZE_Y;
    }

    public int getMinX(){
        return TABLE_MIN_SIZE_X;
    }

    public int getMinY(){
        return TABLE_MIN_SIZE_Y;
    }

    public Robot getActiveRobot() {
        return robots.get(activeRobotId);
    }
    public int getActiveRobotId() {
        return activeRobotId;
    }

    public void setActiveRobotId(int activeRobotId) {
        this.activeRobotId = activeRobotId;
    }

    public Map<Integer, Robot> getRobots() {
        return robots;
    }

    public void setRobots(Map<Integer, Robot> robots) {
        this.robots = robots;
    }

    public Robot getRobot() {
        return robots.get(activeRobotId);
    }

    public void addRobot(Robot robot) {
        int id = robots.keySet().stream().max(Integer::compareTo).orElse(0) + 1;
        robot.setId(id);
        robots.put(id, robot);
        activeRobotId = id;
    }

    public void removeRobot(Integer id) {
        robots.remove(id);
        activeRobotId = robots.keySet().stream().max(Integer::compareTo).orElse(1);
    }
}