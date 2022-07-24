package robot.challenge.command;

import robot.challenge.exception.UnsupportedCommandException;
import robot.challenge.model.Position;

import java.util.Optional;

public interface Command {

    /**
     * Execute the command and return expected new @{@link Position}
     *
     * @param currentPosition
     * @return
     * @throws UnsupportedCommandException
     */
    Optional<Position> execute(final Position currentPosition) throws UnsupportedCommandException;
}
