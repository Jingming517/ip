package tasks;

import dukeexception.DukeException;
import dukeexception.DukeExceptionDetector;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return taskList;
    }

    public static void addList(ArrayList<Task> taskList, String taskDescription, String type) throws DukeException {
        switch (type) {
        case "todo":
            taskList.add(new Todo(taskDescription, false));
            break;

        case "deadline":
            String commandDeadlineSplit[] = DukeExceptionDetector.extractTaskTime(taskDescription, type);
            taskList.add(new Deadline(commandDeadlineSplit[0], false, commandDeadlineSplit[1]));
            break;

        case "event":
            String commandEventSplit[] = DukeExceptionDetector.extractTaskTime(taskDescription, type);
            taskList.add(new Event(commandEventSplit[0], false, commandEventSplit[1]));
            break;

        default:
            break;
        }
    }
    public static void markTaskAsDone(ArrayList<Task> taskList, String command) {
        messages.Message.printSeparationLine();
        int index = Integer.parseInt(command);
        if (index >0 && index <= (taskList.size())) {
            taskList.get(index - 1).markAsDone();
            System.out.println("\tNice! I've marked this task as done:");
            System.out.println("\t   " + taskList.get(index - 1).toString());
        } else {
            System.out.println("\tTask number " + index + " is not in the list.");
        }
        messages.Message.printSeparationLine();
    }
}