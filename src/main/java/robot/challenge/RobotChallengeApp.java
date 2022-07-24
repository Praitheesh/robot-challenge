package robot.challenge;

import robot.challenge.controller.RobotController;
import robot.challenge.model.Table;
import robot.challenge.service.RobotService;
import robot.challenge.util.Constants;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class RobotChallengeApp {
    public static void main(String[] args) {
        RobotController robotController = new RobotController(new Table());
        RobotService.print(Constants.WELCOME_MESSAGE);
        RobotService.print(Constants.VALID_INPUT_MESSAGE);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> stream = in.lines();
        stream.map(String::toUpperCase).map(String::trim).forEach(robotController::executeInput);
    }
}
