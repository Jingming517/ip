package commands;

import tasks.Task;
import java.util.ArrayList;
import dukeexception.*;
public class Command {

    public static void commendProcessor(ArrayList<Task> taskList, String command) {
        try {
            String[] split = DukeExceptionDetector.extractCommandAction(command);
            String commandType = split[0];
            String taskDescription;

            if (split.length > 1) {
                taskDescription = split[1];
            } else {
                taskDescription = "";
            }

            switch (commandType) {
            case "done":
                tasks.TaskList.markTaskAsDone(taskList, split[1]);
                break;
            case "list":
                messages.Message.printAllTasks(taskList);
                break;
            case "todo":
                tasks.TaskList.addList(taskList, taskDescription, "todo");
                messages.Message.printAddTask(taskList);
                break;
            case "event":
                tasks.TaskList.addList(taskList, taskDescription, "event");
                messages.Message.printAddTask(taskList);
                break;
            case "deadline":
                tasks.TaskList.addList(taskList, taskDescription, "deadline");
                messages.Message.printAddTask(taskList);
                break;
            case "help":
                messages.Message.printCommandInstructions();
                break;
            default:
                messages.Message.printSeparationLine();
                System.out.println("\t☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                messages.Message.printSeparationLine();
                break;
            }
        } catch (DukeException e) {
            System.out.println(e.getMessage());
        }


    }
}