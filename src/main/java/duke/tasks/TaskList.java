package duke.tasks;

import duke.dukeexception.*;
import duke.messages.*;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;
    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return taskList;
    }

    public void addTask(String taskDescription, String type) throws DukeException {
        int size = taskList.size();
        switch (type) {
        case "todo":
            taskList.add(new Todo(taskDescription, false));
            duke.messages.Message.printAddTask(taskList.get(size), size);
            break;
        case "deadline":
            String commandDeadlineSplit[] = DukeExceptionDetector.extractTaskTime(taskDescription, type);
            taskList.add(new Deadline(commandDeadlineSplit[0], false, commandDeadlineSplit[1]));
            duke.messages.Message.printAddTask(taskList.get(size), size);
            break;
        case "event":
            String commandEventSplit[] = DukeExceptionDetector.extractTaskTime(taskDescription, type);
            taskList.add(new Event(commandEventSplit[0], false, commandEventSplit[1]));
            duke.messages.Message.printAddTask(taskList.get(size), size);
            break;
        default:
            break;
        }
    }

    public void deleteTask(String command) {
        duke.messages.Message.printSeparationLine();
        int index = Integer.parseInt(command);
        if (index >0 && index <= (taskList.size())) {
            System.out.println("\t Noted. I've removed this task: ");
            System.out.println("\t   " + taskList.get(index - 1).toString());
            taskList.remove(index - 1);
        } else {
            System.out.println("\t Task number " + index + " is not in the list.");
        }
        duke.messages.Message.printSeparationLine();
    }

    public void markTaskAsDone(String command) {
        duke.messages.Message.printSeparationLine();
        int index = Integer.parseInt(command);
        if (index >0 && index <= (taskList.size())) {
            taskList.get(index - 1).markAsDone();
            System.out.println("\t Nice! I've marked this task as done:");
            System.out.println("\t   " + taskList.get(index - 1).toString());
        } else {
            System.out.println("\t Task number " + index + " is not in the list.");
        }
        duke.messages.Message.printSeparationLine();
    }

    public void printAllTasks() {
        duke.messages.Message.printSeparationLine();
        System.out.println("\t Here are the tasks in your list:");
        int number = 1;
        for(int i=0; i < taskList.size(); i++) {
            System.out.println("\t "
                    + number
                    + "."
                    + taskList.get(i).toString());
            number++;
        }
        duke.messages.Message.printSeparationLine();
    }
}