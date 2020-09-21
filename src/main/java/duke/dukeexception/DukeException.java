package duke.dukeexception;

/**
 * Encapsulates a DukeException class.
 */
public class DukeException extends Exception {
    /**
     * Constructs a DukeException object.
     * @param errorMessage
     */
    public DukeException(String errorMessage) {
        super(errorMessage);
    }
}
