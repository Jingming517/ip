package tasks;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return taskList;
    }

    public static void addList(ArrayList<Task> taskList, String taskDescription, String type) {
        switch (type) {
        case "todo":
            taskList.add(new Todo(taskDescription, false));
            break;

        case "deadline":
            String[] deadlineSplit = taskDescription.split("/by", 2);
            String by;
            if (deadlineSplit.length > 1) {
                by = deadlineSplit[1];
            } else {
                by = "";
            }
            String byTrim = by.trim();
            taskList.add(new Deadline(deadlineSplit[0], false, byTrim));
            break;

        case "event":
            String[] eventSplit = taskDescription.split("/at", 2);
            String at;
            if (eventSplit.length > 1) {
                at = eventSplit[1];
            } else {
                at = "";
            }
            String atTrim = at.trim();
            taskList.add(new Event(eventSplit[0], false, atTrim));
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