package duke;

import duke.storage.Storage;

public class Duke {
    public static void main(String[] args) {
        duke.tasks.TaskList list = new duke.tasks.TaskList();
        duke.commands.Command command = new duke.commands.Command(list);
        command.commandProcessor();
        Storage storage = new Storage(list);
        storage.saveData();
    }
}
