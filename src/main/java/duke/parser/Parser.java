package duke.parser;
import duke.dukeexception.DukeException;
import duke.messages.Message;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Parser {

    public static String[] extractCommandAction(String command) throws DukeException {
        String[] split = command.split(" ", 2);
        String commandType = split[0];

        if (split.length == 0) {
            throw new DukeException(Message.EMPTY_COMMAND_ERROR);
        } else if (split.length == 1) {
            switch (commandType) {
            case "list":
            case "timeline":
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
        } else {
            switch (commandType) {
            case("done"):
            case("delete"):
            case("todo"):
            case("event"):
            case("deadline"):
            case("find"):
                return split;
            default:
                throw new DukeException(Message.INVALID_COMMAND_ERROR);
            }
        }
    }

    public static String[] extractTaskTime(String command, String commandType) throws DukeException{
        String[] split = command.split(" /by | /at ", 2);
        if (split.length == 1) {
            switch (commandType) {
            case ("event"):
                throw new DukeException(Message.EMPTY_EVENT_TIME_ERROR);
            case ("deadline"):
                throw new DukeException(Message.EMPTY_DEADLINE_TIME_ERROR);
            }
        }
        return split;
    }

    public static LocalDate timeProcessor(String time) throws DukeException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate ld = LocalDate.parse(time, formatter);
            String valid = ld.format(formatter);
            if (!valid.equals(time)) {
                throw new DukeException(duke.messages.Message.DATE_FORMAT_ERROR);
            }
            return ld;
        } catch (DateTimeParseException | DukeException exp) {
            throw new DukeException(duke.messages.Message.DATE_FORMAT_ERROR);
        }
    }
}

