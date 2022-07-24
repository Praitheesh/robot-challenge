package robot.challenge.command;

import robot.challenge.exception.UnsupportedCommandException;
import robot.challenge.model.CommandEnum;
import robot.challenge.model.Table;
import robot.challenge.model.TurnEnum;
import robot.challenge.util.Constants;

public class CommandFactory {

    private Table table;

    public CommandFactory() {}

    public CommandFactory(Table table) {
        this.table = table;
    }

    public Command getCommand(String input) throws UnsupportedCommandException {
        if (input.startsWith(CommandEnum.PLACE.toString())) {
            return new PlaceCommand(input);
        } else if (input.equals(CommandEnum.LEFT.toString())) {
            return new TurnCommand(TurnEnum.LEFT);
        } else if (input.equals(CommandEnum.RIGHT.toString())) {
            return new TurnCommand(TurnEnum.RIGHT);
        } else if (input.equals(CommandEnum.MOVE.toString())) {
            return new MoveCommand();
        } else if (input.equals(CommandEnum.REPORT.toString())) {
            return new ReportCommand(table);
        } else if (input.contains(CommandEnum.ROBOT.toString())) {
            return new RobotCommand(table, input);
        }else {
            throw new UnsupportedCommandException(Constants.INVALID_INPUT);
        }
    }
}