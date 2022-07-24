package robot.challenge.command;

import robot.challenge.exception.UnsupportedCommandException;
import robot.challenge.model.Position;

import java.util.Optional;

public class MoveCommand implements Command {

    @Override
    public Optional<Position> execute(Position currentPosition) throws UnsupportedCommandException {
        return Optional.empty();
    }
}