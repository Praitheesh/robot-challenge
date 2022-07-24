package robot.challenge.command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import robot.challenge.exception.UnsupportedCommandException;

class CommandFactoryTest {
    @Test
    public void testUnsupportedCommand() {
        Assertions.assertThrows(UnsupportedCommandException.class, () -> {
            CommandFactory factory = new CommandFactory();
            factory.getCommand("INVALID INPUT");
                });

    }

    @Test
    public void testMoveCommand() throws UnsupportedCommandException {
        CommandFactory factory = new CommandFactory();
        assertTrue(factory.getCommand("MOVE") instanceof MoveCommand);
        assertTrue(factory.getCommand("PLACE 4,5,NORTH") instanceof PlaceCommand);
        assertTrue(factory.getCommand("LEFT") instanceof TurnCommand);
        assertTrue(factory.getCommand("RIGHT") instanceof TurnCommand);
        assertTrue(factory.getCommand("REPORT") instanceof ReportCommand);
    }
}