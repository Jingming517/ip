package duke.storage;

import duke.tasks.Task;

import java.io.FileWriter;
import java.io.IOException;

public class Storage {
    private static final String FILE_PATH = "duke.txt";

    private duke.tasks.TaskList taskList;

    public Storage(duke.tasks.TaskList list) {
        this.taskList = list;
    }
    public void saveData() {
        try {
            FileWriter fw = new FileWriter(FILE_PATH);

            for (Task task : taskList.getTasks()) {
                fw.write(task.getTaskType() + " | "
                        + task.getStatusIcon() + " | "
                        + task.getTaskDescription() + " | "
                        + task.getTaskTime()
                        + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}