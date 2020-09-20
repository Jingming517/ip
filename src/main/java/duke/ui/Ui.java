package duke.ui;

import duke.parser.Parser;
import duke.tasks.*;

import java.util.Scanner;

import duke.dukeexception.*;
public class Ui {
    private TaskList list;
    public Ui(TaskList list) {
        this.list = list;
    }

    public void commandProcessor() {
        duke.messages.Message.printWelcome();
        Scanner in = new Scanner(System.in);
        String command;

        while (true) {
            command = in.nextLine();
            if (command.equals("bye")) {
                duke.messages.Message.printGoodBye();
                break;
            }
            else {
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
                    case "todo":
                        list.addTask(taskDescription, "todo");
                        break;
                    case "event":
                        list.addTask(taskDescription, "event");
                        break;
                    case "deadline":
                        list.addTask(taskDescription, "deadline");
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
    }
}