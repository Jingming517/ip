package duke.storage;

import duke.tasks.*;
import duke.storage.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Storage {
    private static final String FILE_PATH = "duke.txt";

    private duke.tasks.TaskList taskList;

    public Storage(duke.tasks.TaskList list) {
        this.taskList = list;
    }

    public void loadData() {
        try {
            File directory = new File(FILE_PATH);
            if (!directory.exists()) {
                System.out.println(duke.messages.Message.FILE_NOT_FOUND);
                directory.mkdir();
            }
            File dukeFile = new File(FILE_PATH);
            Scanner in = new Scanner(dukeFile);
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
                    taskList.getTasks().add(new Deadline(parsed[2], status, parsed[3]));
                    break;
                case "E":
                    taskList.getTasks().add(new Event(parsed[2], status, parsed[3]));
                    break;
                }
            }
            System.out.println("\t " + duke.messages.Message.FILE_LOADED);
        } catch (IOException e) {
            e.printStackTrace();
        }
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