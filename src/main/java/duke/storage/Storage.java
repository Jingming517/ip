package duke.storage;

import duke.dukeexception.DukeException;
import duke.tasks.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Encapsulates a Storage object that saves data to file and loads saved files
 */
public class Storage {
    private static final String DIRECTORY_PATH = "duke";
    private static final String FILE_PATH = "duke/duke.txt";

    private duke.tasks.TaskList taskList;

    public Storage(duke.tasks.TaskList list) {
        this.taskList = list;
    }

    /**
     * Loads saved data form txt file.
     * @return
     */
    public void loadData() {
        String loadingMessage = "";
        try {
            File directory = new File(DIRECTORY_PATH);

            if (!directory.exists()) {
                directory.mkdir();
            }
            assert directory.exists() : "/t The directory does not exist.";

            File f = new File(FILE_PATH);

            Scanner in = new Scanner(f);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] parsed = line.split("\\|");
                String command = parsed[0].trim();
                Boolean status;
                if (parsed[1] == "\u2713") {
                    status = true;
                } else {
                    status = false;
                }

                switch (command) {
                case "T":
                    taskList.getTasks().add(new Todo(parsed[2], status));
                    break;
                case "D":
                    LocalDate deadlineTime = duke.parser.Parser.timeProcessor(parsed[3].trim());
                    taskList.getTasks().add(new Deadline(parsed[2], status, deadlineTime));
                    break;
                case "E":
                    LocalDate eventTime = duke.parser.Parser.timeProcessor(parsed[3].trim());
                    taskList.getTasks().add(new Event(parsed[2], status, eventTime));
                    break;
                }
            }
            System.out.println("\t " + duke.messages.Message.FILE_LOADED);
        } catch (IOException | DukeException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves data to duke.txt file.
     */
    public void saveData() {
        try {
            FileWriter fw = new FileWriter(FILE_PATH);

            for (Task task : taskList.getTasks()) {
                String time = task.getTaskTime().trim();
                String timeFormatted = time.replace(" ", "-");
                fw.write(task.getTaskType() + " | "
                        + task.getStatusIcon() + " | "
                        + task.getTaskDescription().trim() + " | "
                        + timeFormatted
                        + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}