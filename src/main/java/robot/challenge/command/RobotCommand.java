package robot.challenge.command;

import robot.challenge.exception.UnsupportedCommandException;
import robot.challenge.model.CommandEnum;
import robot.challenge.model.Position;
import robot.challenge.model.Table;
import robot.challenge.model.TurnEnum;
import robot.challenge.util.Constants;

import java.util.Optional;

public class RobotCommand implements Command {

    private Table table;
    private String inputString;

    public RobotCommand(Table table, String inputString) {
        this.table = table;
        this.inputString = inputString;
    }

    @Override
    public Optional<Position> execute(Position position) throws UnsupportedCommandException {
        try {
            int activeRobotId = Integer.valueOf(inputString.replaceAll(CommandEnum.ROBOT.toString(), "").trim());
            table.setActiveRobotId(activeRobotId);
        } catch (Exception e) {
            throw new UnsupportedCommandException(Constants.INVALID_INPUT);
        }
        return Optional.empty();
    }
}