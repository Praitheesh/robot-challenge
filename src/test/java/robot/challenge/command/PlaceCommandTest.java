package robot.challenge.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import robot.challenge.exception.UnsupportedCommandException;
import robot.challenge.model.Facing;
import robot.challenge.model.Position;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaceCommandTest {
    @Test
    public void testValidPlaceCommand1() throws UnsupportedCommandException {


        String VALID_PLACE_1 = "PLACE 2,3,EAST";
        String VALID_PLACE_2 = "PLACE 0, 0 ,NORTH";
        String VALID_PLACE_3 = "PLACE 5, 5 ,WEST";
        String VALID_PLACE_4 = "PLACE 0,5,  SOUTH";

        PlaceCommand placeCommand1 = new PlaceCommand(VALID_PLACE_1);
        Optional<Position> position1 = placeCommand1.execute(null);
        assertEquals(2, position1.get().getX());
        assertEquals(3, position1.get().getY());
        assertEquals(Facing.EAST, position1.get().getFacing());

        PlaceCommand placeCommand2 = new PlaceCommand(VALID_PLACE_2);
        Optional<Position> position2 = placeCommand2.execute(null);
        assertEquals(0, position2.get().getX());
        assertEquals(0, position2.get().getY());
        assertEquals(Facing.NORTH, position2.get().getFacing());

        PlaceCommand placeCommand3 = new PlaceCommand(VALID_PLACE_3);
        Optional<Position> position3 = placeCommand3.execute(null);
        assertEquals(5, position3.get().getX());
        assertEquals(5, position3.get().getY());
        assertEquals(Facing.WEST, position3.get().getFacing());

        PlaceCommand placeCommand4 = new PlaceCommand(VALID_PLACE_4);
        Optional<Position> position4 = placeCommand4.execute(null);
        assertEquals(0, position4.get().getX());
        assertEquals(5, position4.get().getY());
        assertEquals(Facing.SOUTH, position4.get().getFacing());

    }

    @Test
    public void testInvalidPlaceCommand1() {
        Assertions.assertThrows(UnsupportedCommandException.class, () -> {
            String INVALID_PLACE = "PLACE2,3,EAST";

            PlaceCommand placeCommand = new PlaceCommand(INVALID_PLACE);
            Optional<Position> position = placeCommand.execute(null);
            assertEquals(2, position.get().getX());
            assertEquals(3, position.get().getY());
            assertEquals(Facing.EAST, position.get().getFacing());
        });

    }

    @Test
    public void testInvalidPlaceCommand2() {
        Assertions.assertThrows(UnsupportedCommandException.class, () -> {

            String INVALID_PLACE = "PLACE e2,3, NORTH";

            PlaceCommand placeCommand = new PlaceCommand(INVALID_PLACE);
            Optional<Position> position = placeCommand.execute(null);
            assertEquals(2, position.get().getX());
            assertEquals(3, position.get().getY());
            assertEquals(Facing.NORTH, position.get().getFacing());
        });
    }

    @Test
    public void testInvalidPlaceCommand3() {
        Assertions.assertThrows(UnsupportedCommandException.class, () -> {
            String INVALID_PLACE = "PLACE 12234,3, NORTH";

            PlaceCommand placeCommand = new PlaceCommand(INVALID_PLACE);
            Optional<Position> position = placeCommand.execute(null);
            assertEquals(12234, position.get().getX());
            assertEquals(3, position.get().getY());
            assertEquals(Facing.NORTH, position.get().getFacing());
        });

    }

    @Test
    public void testInvalidPlaceCommand4() {
        Assertions.assertThrows(UnsupportedCommandException.class, () -> {
            String INVALID_PLACE = "PLACE 3,-3, SOUTH";

            PlaceCommand placeCommand = new PlaceCommand(INVALID_PLACE);
            Optional<Position> position = placeCommand.execute(null);
            assertEquals(3, position.get().getX());
            assertEquals(-3, position.get().getY());
            assertEquals(Facing.SOUTH, position.get().getFacing());
        });

    }

    @Test
    public void testInvalidPlaceCommand5() {

        Assertions.assertThrows(UnsupportedCommandException.class, () -> {
            String INVALID_PLACE = "PLACE 3,3, SOUTHEAST";

            PlaceCommand placeCommand = new PlaceCommand(INVALID_PLACE);
            Optional<Position> position = placeCommand.execute(null);
            assertEquals(3, position.get().getX());
            assertEquals(3, position.get().getY());
            assertEquals(Facing.EAST, position.get().getFacing());
        });

    }

}