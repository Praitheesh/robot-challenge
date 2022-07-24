package robot.challenge.model;

public class Position {

    private int x;
    private int y;
    private Facing facing;

    public Position(int x, int y , Facing f) {
        this.x = x;
        this.y = y;
        this.facing = f;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Facing getFacing() {
        return facing;
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
    }
}