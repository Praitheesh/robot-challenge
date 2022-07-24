package robot.challenge.model;

public enum Facing {
    NORTH, EAST, SOUTH, WEST;

    /**
     * Rotate Facing by +90 degrees
     * @return
     */
    public Facing turnLeft() {
        return values()[(ordinal()+4 - 1) % 4];
    }

    /**
     * Rotate the Facing by -90 degrees
     * @return
     */
    public Facing turnRight() {
        return values()[(ordinal() + 1) % 4];
    }
}