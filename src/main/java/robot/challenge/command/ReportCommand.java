package robot.challenge.command;

import robot.challenge.model.Position;
import robot.challenge.model.Table;
import robot.challenge.service.RobotService;
import robot.challenge.util.Constants;

import java.util.Optional;

public class ReportCommand implements Command {
    private Table table;

    public ReportCommand() {}

    public ReportCommand(Table table) {
        this.table = table;
    }

    @Override
    public Optional<Position> execute(Position currentPosition) {
        RobotService robotService = new RobotService();
        if(table != null) {
            robotService.print("There are " + table.getRobots().size() + " robots. Active Robot number is " + table.getActiveRobotId());
        }
        robotService.print(Constants.REPORT_OUTPUT,
                String.valueOf(currentPosition.getX()),
                String.valueOf(currentPosition.getY()),
                currentPosition.getFacing().toString());
        return Optional.empty();
    }
}