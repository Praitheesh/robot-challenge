package robot.challenge.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import robot.challenge.command.MoveCommand;
import robot.challenge.command.PlaceCommand;
import robot.challenge.command.ReportCommand;
import robot.challenge.command.TurnCommand;
import robot.challenge.exception.PositionOutOfBoundException;
import robot.challenge.exception.UnsupportedCommandException;
import robot.challenge.model.Facing;
import robot.challenge.model.Robot;
import robot.challenge.model.Table;
import robot.challenge.model.TurnEnum;

import static org.junit.jupiter.api.Assertions.*;

class RobotControllerTest {
    Table table = new Table(5, 5);
    RobotController controller = new RobotController(table);

    @Test
    public void testPlaceRobotTest() throws PositionOutOfBoundException, UnsupportedCommandException {
        table.setRobot(new Robot());
        controller.operateRobot(table, new PlaceCommand("PLACE 3,4,NORTH"));
        assertEquals(3, table.getRobot().getPosition().getX());
        assertEquals(4, table.getRobot().getPosition().getY());
        assertEquals(Facing.NORTH, table.getRobot().getPosition().getFacing());
    }

    @Test
    public void testWithOutPlaceFirstTest() {
        Assertions.assertThrows(UnsupportedCommandException.class, () -> {
            table.setRobot(new Robot());
            controller.operateRobot(table, new PlaceCommand("MOVE"));
            assertEquals(3, table.getRobot().getPosition().getX());
            assertEquals(4, table.getRobot().getPosition().getY());
            assertEquals(Facing.NORTH, table.getRobot().getPosition().getFacing());
        });

    }

    @Test
    public void testMove() throws PositionOutOfBoundException, UnsupportedCommandException {
        table.setRobot(new Robot());
        controller.operateRobot(table, new PlaceCommand("PLACE 4,4,EAST"));
        controller.operateRobot(table, new MoveCommand());
        assertEquals(5, table.getRobot().getPosition().getX());
        assertEquals(4, table.getRobot().getPosition().getY());
        assertEquals(Facing.EAST, table.getRobot().getPosition().getFacing());
    }

    @Test
    public void testPlaceMoveTurn() {
        Assertions.assertThrows(PositionOutOfBoundException.class, () -> {
            table.setRobot(new Robot());
            controller.operateRobot(table, new PlaceCommand("PLACE 4,4,EAST"));
            controller.operateRobot(table, new MoveCommand());
            assertEquals(5, table.getRobot().getPosition().getX());
            assertEquals(4, table.getRobot().getPosition().getY());
            assertEquals(Facing.EAST, table.getRobot().getPosition().getFacing());

            controller.operateRobot(table, new TurnCommand(TurnEnum.LEFT));
            controller.operateRobot(table, new MoveCommand());
            assertEquals(5, table.getRobot().getPosition().getX());
            assertEquals(5, table.getRobot().getPosition().getY());
            assertEquals(Facing.NORTH, table.getRobot().getPosition().getFacing());

            controller.operateRobot(table, new MoveCommand());
        });

    }

    @Test
    public void testExampleA() throws PositionOutOfBoundException, UnsupportedCommandException {
        table.setRobot(new Robot());
        controller.operateRobot(table, new PlaceCommand("PLACE 0,0,NORTH"));
        controller.operateRobot(table, new MoveCommand());
        controller.operateRobot(table, new ReportCommand());
        assertEquals(0, table.getRobot().getPosition().getX());
        assertEquals(1, table.getRobot().getPosition().getY());
        assertEquals(Facing.NORTH, table.getRobot().getPosition().getFacing());
    }

    @Test
    public void testExampleB() throws PositionOutOfBoundException, UnsupportedCommandException {
        table.setRobot(new Robot());
        controller.operateRobot(table, new PlaceCommand("PLACE 0,0,NORTH"));
        controller.operateRobot(table, new TurnCommand(TurnEnum.LEFT));
        controller.operateRobot(table, new ReportCommand());
        assertEquals(0, table.getRobot().getPosition().getX());
        assertEquals(0, table.getRobot().getPosition().getY());
        assertEquals(Facing.WEST, table.getRobot().getPosition().getFacing());
    }

    @Test
    public void testExampleC() throws PositionOutOfBoundException, UnsupportedCommandException {
        table.setRobot(new Robot());
        controller.operateRobot(table, new PlaceCommand("PLACE 1,2,EAST"));
        controller.operateRobot(table, new MoveCommand());
        controller.operateRobot(table, new MoveCommand());
        controller.operateRobot(table, new TurnCommand(TurnEnum.LEFT));
        controller.operateRobot(table, new MoveCommand());
        controller.operateRobot(table, new ReportCommand());
        assertEquals(3, table.getRobot().getPosition().getX());
        assertEquals(3, table.getRobot().getPosition().getY());
        assertEquals(Facing.NORTH, table.getRobot().getPosition().getFacing());
    }
}