package robot.challenge.service;

import org.junit.jupiter.api.Test;
import robot.challenge.model.Facing;
import robot.challenge.model.Position;
import robot.challenge.model.Robot;
import robot.challenge.model.Table;

import static org.junit.jupiter.api.Assertions.*;

class RobotServiceTest {
    RobotService robotService = new RobotService();

    @Test
    public void testValidatePosition() {
        Table table = new Table(10, 10);
        table.addRobot(new Robot());
        assertTrue(robotService.validateRobotPosition(table, new Position(3, 4, Facing.NORTH)));
    }

    @Test
    public void testValidateBorderXPosition() {
        Table table = new Table(10, 10);
        table.addRobot(new Robot());
        assertTrue(robotService.validateRobotPosition(table, new Position(10, 4, Facing.EAST)));
    }

    @Test
    public void testValidateBorderYPosition() {
        Table table = new Table(10, 10);
        table.addRobot(new Robot());
        assertTrue(robotService.validateRobotPosition(table, new Position(10, 10, Facing.EAST)));
    }

    @Test
    public void testValidateBorderMinPosition() {
        Table table = new Table(10, 10);
        table.addRobot(new Robot());
        assertTrue(robotService.validateRobotPosition(table, new Position(0, 0, Facing.EAST)));
    }

    @Test
    public void testValidateOutOfBorderXPosition() {
        Table table = new Table(10, 10);
        table.addRobot(new Robot());
        assertFalse(robotService.validateRobotPosition(table, new Position(11, 3, Facing.SOUTH)));
    }

    @Test
    public void testValidateOutOfBorderMinPosition() {
        Table table = new Table(10, 10);
        table.addRobot(new Robot());
        assertFalse(robotService.validateRobotPosition(table, new Position(-8, -3, Facing.EAST)));
    }
}