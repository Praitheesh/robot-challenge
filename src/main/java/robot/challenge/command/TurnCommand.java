package robot.challenge.command;

import robot.challenge.model.Position;
import robot.challenge.model.TurnEnum;

import java.util.Optional;

public class TurnCommand implements Command {
    private TurnEnum turn;

    public TurnCommand(TurnEnum turn) {
        this.turn = turn;
    }

    @Override
    public Optional<Position> execute(Position position) {
        return Optional.of(new Position(position.getX(), position.getY(),
                turn == TurnEnum.LEFT ? position.getFacing().turnLeft()
                        : position.getFacing().turnRight()));
    }
}