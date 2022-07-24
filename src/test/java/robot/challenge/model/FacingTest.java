package robot.challenge.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacingTest {
    @Test
    public void testTurnLeftEnum(){
        assertEquals(Facing.EAST,Facing.NORTH.turnRight());
        assertEquals(Facing.EAST,Facing.SOUTH.turnLeft());
        assertEquals(Facing.NORTH,Facing.EAST.turnLeft());
        assertEquals(Facing.NORTH,Facing.WEST.turnRight());
        assertEquals(Facing.SOUTH,Facing.WEST.turnLeft());
        assertEquals(Facing.SOUTH,Facing.EAST.turnRight());
        assertEquals(Facing.WEST,Facing.NORTH.turnLeft());
        assertEquals(Facing.WEST,Facing.SOUTH.turnRight());
    }
}