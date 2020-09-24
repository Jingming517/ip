package duke.parser;

import duke.dukeexception.DukeException;
import duke.messages.Message;
import duke.tasks.TaskList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Encapsulates the Parser class that parses user input string.
 */

public class Parser {
    /**
     * Extracts command action word from user input string.
     * @param command user input command.
     * @return an array of string including [command type] and [description].
     * @throws DukeException throws exception on empty commands and invalid commands.
     */
    public static String[] extractCommandAction(String command) throws DukeException {
        String[] split = command.split(" ", 2);
        String commandType = split[0];
        if (split.length == 0) {
            throw new DukeException(Message.EMPTY_COMMAND_ERROR);
        } else if (split.length == 1) {
            switch (commandType) {
            case "list":
            case "timeline":
            case "sort":
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
            case("date"):
                return split;
            default:
                throw new DukeException(Message.INVALID_COMMAND_ERROR);
            }
        }
    }

    /**
     * Extracts date from command string.
     * @param command user input command.
     * @param commandType Type of command.
     * @return an array of string [description, date].
     * @throws DukeException throws an exception on empty date.
     */
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

    /**
     * Converts date from String to LocalDate.
     * @param time date string.
     * @return date in LocalDate format.
     * @throws DukeException throws a duke exception on invalid date format.
     */
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

