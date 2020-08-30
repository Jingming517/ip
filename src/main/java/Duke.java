import tasks.Task;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    public static ArrayList<Task> taskList = new ArrayList<Task>();

    public static void main(String[] args) {
        messages.Message.printWelcome();
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            command = in.nextLine();
            if (command.equals("bye")) {
                messages.Message.printGoodBye();
                break;
            }
            else {
                commands.Command.commendProcessor(taskList, command);
            }
        }
    }
}
