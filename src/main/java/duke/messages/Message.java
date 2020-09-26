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
    public static final String FILE_NOT_FOUND = "☹ OOPS!!! The save file is not found.";
    public static final String DIRECTORY_NOT_FOUND = "☹ OOPS!!! The directory is not found.";
    public static final String FILE_LOADED = "File successfully loaded.";
    public static final String DATE_FORMAT_ERROR = "☹ OOPS!!! Please input date in yyyy-mm-dd format";
    public static final String FILE_LOADING = "The file is loading";

    public static void printSeparationLine() {
        System.out.println("\t____________________________________________________________");
    }

    /**
     * Prints task being added.
     * @param taskAdded the task being added.
     * @param size number of tasks in the list.
     */
    public static void printAddTask(Task taskAdded, int size) {
        printSeparationLine();
        System.out.println("\t Got it. I've added this task: ");
        System.out.println("\t   "
                + taskAdded.toString());
        int numberOfTasks = size + 1;
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


    /**
     * Prints welcome messages.
     */
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

    /**
     * Prints goodbye messages.
     */
    public static void printGoodBye() {
        printSeparationLine();
        System.out.println("\t Bye.Hope to see you again soon!");
        printSeparationLine();
        return;
    }

    /**
     * Prints available commands.
     */
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
                "\n\n\tfind: Find tasks that contain the keyword"+
                "\n\t\tExample: find book" +
                "\n\n\tdate: Find tasks on a certain date"+
                "\n\t\tExample: date 2020-09-23" +
                "\n\n\ttimeline: Print tasks in time order"+
                "\n\t\tExample: timeline" +
                "\n\n\tsort: Sort tasks according to their types"+
                "\n\t\tExample: sort" +
                "\n\n\tbye: Exit the program." +
                "\n\t\tExample: bye");
        printSeparationLine();
    }
}