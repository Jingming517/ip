package duke;

import duke.storage.Storage;
import duke.ui.Ui;

public class Duke {

    public static void main(String[] args) {
        duke.tasks.TaskList list = new duke.tasks.TaskList();
        duke.ui.Ui command = new duke.ui.Ui(list);
        Storage storage = new Storage(list);
        storage.loadData();
        command.commandProcessor();
        storage.saveData();
    }
}
