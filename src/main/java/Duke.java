import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    public static ArrayList<Task> taskList = new ArrayList<Task>();

    public static void main(String[] args) {
        printWelcome();
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            command = in.nextLine();
            if (command.equals("bye")) {
                printGoodBye();
                break;
            }
            else {
                commendProcessor(command);
            }
        }
    }

    //process user input commands
    static void commendProcessor(String command) {
        String[] split = command.split(" ", 2);
        String taskDescription;
        if (split.length > 1) {
            taskDescription = split[1];
        } else {
            taskDescription = "";
        }
        switch (split[0]) {
        case "done":
            int index = Integer.parseInt(split[1]); //task number
            if ((index) <= taskList.size()) {
                taskList.get(index - 1).markAsDone();
                printSeparationLine();
                System.out.println("\tNice! I've marked this task as done:");
                System.out.println("\t   ["
                        + taskList.get(index-1).getStatusIcon()
                        +"] "
                        +taskList.get(index-1).description
                        + "\n");
                printSeparationLine();
            }
        case "list":
            printAllTasks();
            break;
        case "todo":
            addList(taskDescription, "todo");
            printAddTask();
            break;
        case "event":
            addList(taskDescription, "event");
            printAddTask();
            break;
        case "deadline":
            addList(taskDescription, "deadline");
            printAddTask();
            break;
        default:
            break;
        }

    }

    //print methods
    public static void printSeparationLine() {
        System.out.println("\t____________________________________________________________");
    }
    public static void printAddTask() {
        //print the last task that's being added to the list
        printSeparationLine();
        System.out.println("\t Got it. I've added this task: ");
        System.out.println("\t   "
                + taskList.get(taskList.size() - 1).returnTask());
        int numberOfTasks = taskList.size();
        String taskPlural;
        if (numberOfTasks == 0 || numberOfTasks ==1) {
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
    public static void printAllTasks() {
        printSeparationLine();
        System.out.println("\tHere are the tasks in your list:");
        int number = 1;
        for(int i=0; i < taskList.size(); i++) {
            System.out.println("\t "
                    + number
                    + "."
                    + taskList.get(i).returnTask());
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

    //other methods
    public static void echo(String line) {
        printSeparationLine();
        System.out.println("\t " + line);
        printSeparationLine();
    }
    public static void addList(String taskDescription, String type) {
        switch (type) {
        case "todo":
            taskList.add(new ToDo(taskDescription, false));
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


}
