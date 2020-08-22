import java.util.Scanner;
public class Duke {
    public static void goodbye()
    {
        System.out.println("\t____________________________________________________________");
        System.out.println("\t Bye.Hope to see you again soon!");
        System.out.println("\t____________________________________________________________");
    }
    public static void echo(String line) {
        System.out.println("\t____________________________________________________________");
        System.out.println("\t " + line);
        System.out.println("\t____________________________________________________________");
    }

    public static void main(String[] args) {
        /*
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        */
        System.out.println("\t____________________________________________________________");
        System.out.println("\t Hello! I'm Duke");
        System.out.println("\t What can I do for you?");
        System.out.println("\t____________________________________________________________");
        Scanner in=new Scanner(System.in);
        String line;
        line = in.nextLine(); //returns a string
        while (!line.equals("bye")) {
            echo(line);
            line = in.nextLine();
        }
        goodbye();
    }
}
