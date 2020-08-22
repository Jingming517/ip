import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    public static ArrayList<Task> taskList = new ArrayList<Task>();
    public static void main(String[] args) {
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
        Scanner in=new Scanner(System.in);
        String command;
        while (true) {
            command = in.nextLine(); //returns a string
            if (command.equals("bye")) {
                goodbye();
                break;
            }
            else {
                commendProcessor(command);
            }

        }
    }



    public static void printSeparationLine() {
        System.out.println("\t____________________________________________________________");
    }
    public static void goodbye()
    {
        printSeparationLine();
        System.out.println("\t Bye.Hope to see you again soon!");
        printSeparationLine();
        return;
    }
    public static void echo(String line) {
        printSeparationLine();
        System.out.println("\t " + line);
        printSeparationLine();
    }
    static void addList(String command) {
        taskList.add(new Task(command));
        printSeparationLine();
        System.out.println("\t added: " + command);
        printSeparationLine();
    }
    static void listAllTasks() {
        printSeparationLine();
        int number = 1;
        for(int i=0; i<taskList.size(); i++){

            System.out.println("\t " + number + ".[" + taskList.get(i).getStatusIcon() + "]" + taskList.get(i).taskName);
            number++;
        }
        printSeparationLine();
    }

    static void commendProcessor(String command) {
        String[] split = command.split(" ");
        if(split[0].equals(("done"))) {
            int index = Integer.parseInt(split[1]); //task number
            if ((index) <= taskList.size()) {
                taskList.get(index - 1).markAsDone();
                printSeparationLine();
                System.out.println("\tNice! I've marked this task as done:");
                System.out.println("\t   [" + taskList.get(index-1).getStatusIcon() +"] "+taskList.get(index-1).taskName+"\n");
                printSeparationLine();
            }
        }
        else {
            switch (command) {
            case "list":
                listAllTasks();
                break;
            default:
                addList(command);
            }
        }

    }
}
