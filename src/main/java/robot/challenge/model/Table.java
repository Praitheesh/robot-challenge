package robot.challenge.model;

import robot.challenge.util.Constants;

public class Table {
    private Robot robot;
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

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }
}