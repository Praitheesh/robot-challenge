package robot.challenge.command;

import robot.challenge.model.Position;
import robot.challenge.service.RobotService;
import robot.challenge.util.Constants;

import java.util.Optional;

public class ReportCommand implements Command {

    @Override
    public Optional<Position> execute(Position currentPosition) {
        RobotService robotService = new RobotService();
        robotService.print(Constants.REPORT_OUTPUT,
                String.valueOf(currentPosition.getX()),
                String.valueOf(currentPosition.getY()),
                currentPosition.getFacing().toString());
        return Optional.empty();
    }
}