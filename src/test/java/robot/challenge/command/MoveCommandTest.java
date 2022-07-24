package robot.challenge.command;

import org.junit.jupiter.api.Test;
import robot.challenge.model.Facing;
import robot.challenge.model.Position;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveCommandTest {

    @Test
    public void testMoveNorth() {
        Position currentPosition = new Position(0, 0, Facing.NORTH);
        MoveCommand move = new MoveCommand();
        Optional<Position> newPosition = move.execute(currentPosition);
        assertEquals(0, newPosition.get().getX());
        assertEquals(1, newPosition.get().getY());
        assertEquals(Facing.NORTH, newPosition.get().getFacing());
    }

    @Test
    public void testMoveEast() {
        Position currentPosition = new Position(2, 5, Facing.EAST);
        MoveCommand move = new MoveCommand();
        Optional<Position> newPosition = move.execute(currentPosition);
        assertEquals(3, newPosition.get().getX());
        assertEquals(5, newPosition.get().getY());
        assertEquals(Facing.EAST, newPosition.get().getFacing());
    }

    @Test
    public void testMoveSouth() {
        Position currentPosition = new Position(0, 1, Facing.SOUTH);
        MoveCommand move = new MoveCommand();
        Optional<Position> newPosition = move.execute(currentPosition);
        assertEquals(0, newPosition.get().getX());
        assertEquals(0, newPosition.get().getY());
        assertEquals(Facing.SOUTH, newPosition.get().getFacing());
    }

    @Test
    public void testMoveWest() {
        Position currentPosition = new Position(2, 5, Facing.WEST);
        MoveCommand move = new MoveCommand();
        Optional<Position> newPosition = move.execute(currentPosition);
        assertEquals(1, newPosition.get().getX());
        assertEquals(5, newPosition.get().getY());
        assertEquals(Facing.WEST, newPosition.get().getFacing());
    }
}