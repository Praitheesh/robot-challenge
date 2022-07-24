package robot.challenge.command;

import robot.challenge.exception.UnsupportedCommandException;
import robot.challenge.model.Facing;
import robot.challenge.model.Position;
import robot.challenge.util.Constants;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaceCommand implements Command {
    private String inputString;

    public PlaceCommand(String input) {
        this.inputString = input;
    }

    @Override
    public Optional<Position> execute(final Position position) throws UnsupportedCommandException {
        return Optional.of(constructPosition(inputString));
    }

    private Position constructPosition(String input) throws UnsupportedCommandException {
        Pattern pattern = Pattern.compile(Constants.PLACE_COMMAND_PATTERN);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find() && matcher.groupCount() == 3) {
            try {
                return new Position(Integer.valueOf(matcher.group(1)),
                        Integer.valueOf(matcher.group(2)),
                        Facing.valueOf(matcher.group(3).trim()));
            } catch (Exception e) {
                throw new UnsupportedCommandException(Constants.INVALID_PLACE_INPUT);
            }
        } else {
            throw new UnsupportedCommandException(Constants.INVALID_PLACE_INPUT);
        }
    }
}