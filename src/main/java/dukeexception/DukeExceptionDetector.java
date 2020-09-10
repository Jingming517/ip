package dukeexception;
import messages.Message;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DukeExceptionDetector {

    public static String[] extractCommandAction(String command) throws DukeException {
        String[] split = command.split(" ", 2);
        String commandType = split[0];

        if (split.length == 0) {
            throw new DukeException(Message.EMPTY_COMMAND_ERROR);
        }
        else if (split.length == 1) {
            switch (commandType) {
            case "list":
                return split;
            case "todo":
                throw new DukeException(Message.EMPTY_TODO_ERROR);
            case "event":
                throw new DukeException(Message.EMPTY_EVENT_ERROR);
            case "deadline":
                throw new DukeException(Message.EMPTY_DEADLINE_ERROR);
            default:
                throw new DukeException(Message.INVALID_COMMAND_ERROR);
            }
        }
        else {
            switch (commandType) {
            case("done"):
            case("todo"):
            case("event"):
            case("deadline"):
                return split;
            default:
                throw new DukeException(Message.INVALID_COMMAND_ERROR);
            }
        }
    }

    public static String extractTaskTime(String command, String commandType) throws DukeException{
        String[] split = command.split(" /by | /at ", 2);
        if (split.length == 1) {
            switch (commandType) {
            case ("event"):
                throw new DukeException(Message.EMPTY_EVENT_TIME_ERROR);
            case ("deadline"):
                throw new DukeException(Message.EMPTY_DEADLINE_ERROR);
            }
        }
        return split[1];
    }
}