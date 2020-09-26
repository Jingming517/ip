package duke.ui;

import duke.parser.Parser;
import duke.tasks.*;
import duke.dukeexception.*;
import java.util.Scanner;

/**
 * Encapsulates the Ui class that deals with interactions with the user.
 */
public class Ui {
    private TaskList list;
    public Ui(TaskList list) {
        this.list = list;
    }

    /**
     *  Processes and executes the input commands from user.
     */
    public void commandProcessor() {
        duke.messages.Message.printWelcome();
        Scanner in = new Scanner(System.in);
        String command;

        while (true) {
            command = in.nextLine();
            if (command.equals("bye")) {
                duke.messages.Message.printGoodBye();
                break;
            } else if (command.equals("help")){
                duke.messages.Message.printCommandInstructions();
            } else {
                try {
                    String[] split = Parser.extractCommandAction(command);
                    String commandType = split[0];
                    String taskDescription;

                    if (split.length > 1) {
                        taskDescription = split[1];
                    } else {
                        taskDescription = "";
                    }

                    switch (commandType) {
                    case "done":
                        list.markTaskAsDone(split[1]);
                        break;
                    case "delete":
                        list.deleteTask(split[1]);
                        break;
                    case "list":
                        list.printAllTasks();
                        break;
                    case "sort":
                        list.sortTasks();
                        break;
                    case "todo":
                        list.addTask(taskDescription, "todo");
                        break;
                    case "event":
                        list.addTask(taskDescription, "event");
                        break;
                    case "deadline":
                        list.addTask(taskDescription, "deadline");
                        break;
                    case "find":
                        list.findKeyword(split[1].trim());
                        break;
                    case "date":
                        list.findDate(split[1]);
                        break;
                    case "timeline":
                        list.generateTimeline();
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
    }
}