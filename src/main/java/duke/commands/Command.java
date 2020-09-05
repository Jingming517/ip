package duke.commands;

import duke.tasks.*;
import duke.messages.*;
import java.util.ArrayList;
import duke.dukeexception.*;
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
                duke.tasks.TaskList.markTaskAsDone(taskList, split[1]);
                break;
            case "list":
                duke.messages.Message.printAllTasks(taskList);
                break;
            case "todo":
                duke.tasks.TaskList.addList(taskList, taskDescription, "todo");
                duke.messages.Message.printAddTask(taskList);
                break;
            case "event":
                duke.tasks.TaskList.addList(taskList, taskDescription, "event");
                duke.messages.Message.printAddTask(taskList);
                break;
            case "deadline":
                duke.tasks.TaskList.addList(taskList, taskDescription, "deadline");
                duke.messages.Message.printAddTask(taskList);
                break;
            case "help":
                duke.messages.Message.printCommandInstructions();
                break;
            default:
                duke.messages.Message.printSeparationLine();
                System.out.println("\t☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                duke.messages.Message.printSeparationLine();
                break;
            }
        } catch (DukeException e) {
            duke.messages.Message.printSeparationLine();
            System.out.println("\t " + e.getMessage());
            duke.messages.Message.printSeparationLine();
        }
    }
}