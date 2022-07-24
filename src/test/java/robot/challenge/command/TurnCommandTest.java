package robot.challenge.command;

import org.junit.jupiter.api.Test;
import robot.challenge.model.Facing;
import robot.challenge.model.Position;
import robot.challenge.model.TurnEnum;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnCommandTest {
    
    @Test
    public void testTurnRight(){
        TurnCommand turn = new TurnCommand(TurnEnum.RIGHT);
        Position currentPosition = new Position(3,4, Facing.NORTH);
        Optional<Position> newPosition = turn.execute(currentPosition);
        assertEquals(3, newPosition.get().getX());
        assertEquals(4, newPosition.get().getY());
        assertEquals(Facing.EAST, newPosition.get().getFacing());
    }

    @Test
    public void testTurnLeft(){
        TurnCommand turn = new TurnCommand(TurnEnum.LEFT);
        Position currentPosition = new Position(0,0, Facing.NORTH);
        Optional<Position> newPosition = turn.execute(currentPosition);
        assertEquals(0, newPosition.get().getX());
        assertEquals(0, newPosition.get().getY());
        assertEquals(Facing.WEST, newPosition.get().getFacing());
    }
}