package duke;

import duke.storage.Storage;
import duke.ui.Ui;

/**
 * The main class of Duke object.
 */
public class Duke {
    /**
     * Duke program starts.
     * @param args command line inputs into the program.
     */
    public static void main(String[] args) {
        duke.tasks.TaskList list = new duke.tasks.TaskList();
        duke.ui.Ui command = new duke.ui.Ui(list);
        Storage storage = new Storage(list);
        storage.loadData();
        command.commandProcessor();
        storage.saveData();
    }
}