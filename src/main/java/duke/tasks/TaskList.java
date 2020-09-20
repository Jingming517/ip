package duke.tasks;

import duke.dukeexception.*;
import duke.parser.Parser;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(String taskDescription, String type) throws DukeException {
        int size = tasks.size();
        switch (type) {
        case "todo":
            tasks.add(new Todo(taskDescription, false));
            duke.messages.Message.printAddTask(tasks.get(size), size);
            break;
        case "deadline":
            String commandDeadlineSplit[] = Parser.extractTaskTime(taskDescription, type);
            tasks.add(new Deadline(commandDeadlineSplit[0], false, commandDeadlineSplit[1]));
            duke.messages.Message.printAddTask(tasks.get(size), size);
            break;
        case "event":
            String commandEventSplit[] = Parser.extractTaskTime(taskDescription, type);
            tasks.add(new Event(commandEventSplit[0], false, commandEventSplit[1]));
            duke.messages.Message.printAddTask(tasks.get(size), size);
            break;
        default:
            break;
        }
    }

    public void deleteTask(String command) {
        duke.messages.Message.printSeparationLine();
        int index = Integer.parseInt(command);
        if (index >0 && index <= (tasks.size())) {
            System.out.println("\t Noted. I've removed this task: ");
            System.out.println("\t   " + tasks.get(index - 1).toString());
            tasks.remove(index - 1);
        } else {
            System.out.println("\t Task number " + index + " is not in the list.");
        }
        duke.messages.Message.printSeparationLine();
    }

    public void markTaskAsDone(String command) {
        duke.messages.Message.printSeparationLine();
        int index = Integer.parseInt(command);
        if (index >0 && index <= (tasks.size())) {
            tasks.get(index - 1).markAsDone();
            System.out.println("\t Nice! I've marked this task as done:");
            System.out.println("\t   " + tasks.get(index - 1).toString());
        } else {
            System.out.println("\t Task number " + index + " is not in the list.");
        }
        duke.messages.Message.printSeparationLine();
    }

    public void printAllTasks() {
        duke.messages.Message.printSeparationLine();
        System.out.println("\t Here are the tasks in your list:");
        int number = 1;
        for(int i=0; i < tasks.size(); i++) {
            System.out.println("\t "
                    + number
                    + "."
                    + tasks.get(i).toString());
            number++;
        }
        duke.messages.Message.printSeparationLine();
    }
}