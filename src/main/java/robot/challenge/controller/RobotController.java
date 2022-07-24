package robot.challenge.controller;

import robot.challenge.command.Command;
import robot.challenge.command.CommandFactory;
import robot.challenge.command.PlaceCommand;
import robot.challenge.exception.PositionOutOfBoundException;
import robot.challenge.exception.UnsupportedCommandException;
import robot.challenge.model.CommandEnum;
import robot.challenge.model.Position;
import robot.challenge.model.Robot;
import robot.challenge.model.Table;
import robot.challenge.service.RobotService;
import robot.challenge.util.Constants;

import java.util.Optional;

public class RobotController {

    private CommandFactory commandFactory;
    private Table gameTable;
    private boolean isRobotPlaced = false;
    private RobotService robotService;

    public RobotController(Table gameTable) {
        this.gameTable = gameTable;
        this.robotService = new RobotService();
        this.commandFactory = new CommandFactory(gameTable);
    }

    /**
     * Core method to handle inputs
     *
     * @param input
     */
    public void executeInput(String input) {
        try {

            if (input.matches(Constants.PLACE_COMMAND_PATTERN)) {
                //Place the robot on game table
                initGame(input);
            } else if (input.matches(Constants.VALID_NON_PLACE_COMMAND_PATTERN) && !isRobotPlaced) {
                //Robot not placed into game table yet , place it first
                robotService.print(Constants.PLACE_COMMAND_FIRST);
            } else if (input.matches(Constants.VALID_NON_PLACE_COMMAND_PATTERN)) {
                // execute commands
                operateRobot(gameTable, commandFactory.getCommand(input));
            } else {
                // Invalid
                robotService.print(Constants.INVALID_INPUT);
                robotService.print(Constants.VALID_INPUT_MESSAGE);
            }
        } catch (UnsupportedCommandException e) {
            robotService.print(e.getMessage());
            robotService.print(Constants.VALID_INPUT_MESSAGE);
        } catch (PositionOutOfBoundException e) {
            robotService.print(e.getMessage());
        }
    }

    private void initGame(String input) throws UnsupportedCommandException, PositionOutOfBoundException {
        isRobotPlaced = true;
        gameTable.addRobot(new Robot());
        operateRobot(gameTable, commandFactory.getCommand(input));
    }

    public void operateRobot(Table table, Command command) throws UnsupportedCommandException, PositionOutOfBoundException {
        Robot robot = table.getActiveRobot();
        Optional<Position> newPosition = command.execute(robot.getPosition());

        if (newPosition.isPresent()) {
            if(!robotService.validateRobotOccupancy(table, newPosition.get())) {
                if(command instanceof PlaceCommand) {
                    table.removeRobot(robot.getId());
                }
                throw new PositionOutOfBoundException(Constants.POSITION_OCCUPIED_MESSAGE);
            }
            if (robotService.validateRobotPosition(table, newPosition.get())) {
                robot.setPosition(new Position(newPosition.get().getX(), newPosition.get().getY(), newPosition.get().getFacing()));
            } else {
                commandFactory.getCommand(CommandEnum.REPORT.toString()).execute(table.getRobot().getPosition());
                throw new PositionOutOfBoundException(Constants.INVALID_POSITION_MESSAGE);
            }
        }
    }
}