package duke.tasks;

import duke.dukeexception.*;
import duke.parser.Parser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class TaskList {
    private ArrayList<Task> tasks;
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(String taskDescription, String type) throws DukeException {
        int size = tasks.size();
        switch (type) {
        case "todo":
            tasks.add(new Todo(taskDescription, false));
            duke.messages.Message.printAddTask(tasks.get(size), size);
            break;
        case "deadline":
            String commandDeadlineSplit[] = Parser.extractTaskTime(taskDescription, type);
            LocalDate deadlineDateProcessed = Parser.timeProcessor(commandDeadlineSplit[1].trim());
            tasks.add(new Deadline(commandDeadlineSplit[0], false, deadlineDateProcessed));
            duke.messages.Message.printAddTask(tasks.get(size), size);
            break;
        case "event":
            String commandEventSplit[] = Parser.extractTaskTime(taskDescription, type);
            LocalDate eventDateProcessed = Parser.timeProcessor(commandEventSplit[1].trim());
            tasks.add(new Event(commandEventSplit[0], false, eventDateProcessed));
            duke.messages.Message.printAddTask(tasks.get(size), size);
            break;
        default:
            break;
        }
    }

    public void deleteTask(String command) {
        duke.messages.Message.printSeparationLine();
        int index = Integer.parseInt(command);
        if (index >0 && index <= (tasks.size())) {
            System.out.println("\t Noted. I've removed this task: ");
            System.out.println("\t   " + tasks.get(index - 1).toString());
            tasks.remove(index - 1);
        } else {
            System.out.println("\t Task number " + index + " is not in the list.");
        }
        duke.messages.Message.printSeparationLine();
    }

    public void markTaskAsDone(String command) {
        duke.messages.Message.printSeparationLine();
        int index = Integer.parseInt(command);
        if (index >0 && index <= (tasks.size())) {
            tasks.get(index - 1).markAsDone();
            System.out.println("\t Nice! I've marked this task as done:");
            System.out.println("\t   " + tasks.get(index - 1).toString());
        } else {
            System.out.println("\t Task number " + index + " is not in the list.");
        }
        duke.messages.Message.printSeparationLine();
    }

    public void printAllTasks() {
        duke.messages.Message.printSeparationLine();
        System.out.println("\t Here are the tasks in your list:");
        int number = 1;
        for(int i=0; i < tasks.size(); i++) {
            System.out.println("\t "
                    + number
                    + "."
                    + tasks.get(i).toString());
            number++;
        }
        duke.messages.Message.printSeparationLine();
    }
    public void printList(ArrayList<Task> list) {
        int number = 1;
        for (int i=0; i< list.size(); i++) {
            System.out.println("\t "
                    + number
                    + "."
                    + tasks.get(i).toString());
            number++;
        }
    }

    public void findKeyword(String keyword) {
        duke.messages.Message.printSeparationLine();
        int number = 1;
        System.out.println("\t Here are the matching tasks in your list:");
        for (int i=0; i<tasks.size(); i++) {
            String description = tasks.get(i).getTaskDescription();
            if (keywordMatched(keyword, description)) {
                System.out.println("\t "
                        + number
                        + "."
                        + tasks.get(i).toString());
                number++;
            }
        }
        duke.messages.Message.printSeparationLine();
    }
    public boolean keywordMatched(String keyword, String description) {
        if (description.contains(keyword)) {
            return true;
        } else {
            return false;
        }
    }

    public void printTimeline() {
        System.out.println("\t To be implemented.");
        /*
        ArrayList<Task> deadlineList = new ArrayList<>();
        ArrayList<Task> eventList = new ArrayList<>();
        ArrayList<Task> todoList = new ArrayList<>();
        for (int i=0; i<tasks.size(); i++) {
            switch(tasks.get(i).getTaskType()) {
            case "E":
                eventList.add(tasks.get(i));
                break;
            case "D":
                deadlineList.add(tasks.get(i));
                break;
            case "T":
                todoList.add(tasks.get(i));
                break;
            }
        }
        //Collections.sort(deadlineList);
        //Collections.sort(eventList);

        duke.messages.Message.printSeparationLine();
        System.out.println("\t Here is your timeline");
        System.out.println("\t Deadlines:");
        printList(deadlineList);
        System.out.println("\t Events:");
        printList(eventList);
        System.out.println("\t Todos:");
        printList(todoList);
        duke.messages.Message.printSeparationLine();

         */
    }
}