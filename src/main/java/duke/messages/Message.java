package duke.messages;

import duke.tasks.Task;
import java.util.ArrayList;

public class Message {
    /**
     * Error messages
     */
    public static final String EMPTY_COMMAND_ERROR = "☹ OOPS!!! The command input cannot be empty!";
    public static final String INVALID_COMMAND_ERROR = "☹ OOPS!!! Please input a valid command!";
    public static final String EMPTY_TODO_ERROR = "☹ OOPS!!! The description of a todo cannot be empty.";
    public static final String EMPTY_EVENT_ERROR = "☹ OOPS!!! The description of a event cannot be empty.";
    public static final String EMPTY_DEADLINE_ERROR = "☹ OOPS!!! The description of a deadline cannot be empty.";
    public static final String EMPTY_EVENT_TIME_ERROR = "☹ OOPS!!! Please input the time of event.";
    public static final String EMPTY_DEADLINE_TIME_ERROR = "☹ OOPS!!! Please input the time of deadline.";

    public static void printSeparationLine() {
        System.out.println("\t____________________________________________________________");
    }
    public static void printAddTask(ArrayList<Task> taskList) {
        printSeparationLine();
        System.out.println("\t Got it. I've added this task: ");
        System.out.println("\t   "
                + taskList.get(taskList.size() - 1).toString());
        int numberOfTasks = taskList.size();
        String taskPlural;
        if (numberOfTasks == 0 || numberOfTasks == 1) {
            taskPlural = "task";
        } else {
            taskPlural = "tasks";
        }
        System.out.println("\t Now you have "
                + numberOfTasks
                + " "
                + taskPlural
                + " in the list.");
        printSeparationLine();
    }
    public static void printAllTasks(ArrayList<Task> taskList) {
        printSeparationLine();
        System.out.println("\tHere are the tasks in your list:");
        int number = 1;
        for(int i=0; i < taskList.size(); i++) {
            System.out.println("\t "
                    + number
                    + "."
                    + taskList.get(i).toString());
            number++;
        }
        printSeparationLine();
    }
    public static void printWelcome() {
        /*
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        */
        printSeparationLine();
        System.out.println("\t Hello! I'm Duke");
        System.out.println("\t What can I do for you?");
        printSeparationLine();
    }
    public static void printGoodBye() {
        printSeparationLine();
        System.out.println("\t Bye.Hope to see you again soon!");
        printSeparationLine();
        return;
    }
    public static void printCommandInstructions() {
        printSeparationLine();
        System.out.println("\t[List of commands available]" +
                "\n\tlist: Display all tasks in the list." +
                "\n\t\tExample: list" +
                "\n\n\ttodo: Add a todo task." +
                "\n\t\tExample: todo borrow book" +
                "\n\n\tdeadline: Add a deadline." +
                "\n\t\tExample: deadline return book /by Sunday" +
                "\n\n\tevent: Add a event." +
                "\n\t\tExample: event project meeting /at Mon 2-4pm" +
                "\n\n\tdone: Mark a task as done." +
                "\n\t\tExample: done 2" +
                "\n\n\tbye: Exit the program." +
                "\n\t\tExample: bye");
        printSeparationLine();
    }
}