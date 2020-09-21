package duke.tasks;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class Task implements Comparable<Task> {
    public String description;
    public boolean isDone;
    private LocalDate time;

    public Task() {
        description = "";
        isDone = false;
    }
    public Task(String taskInput, boolean status){
        description = taskInput;
        isDone = status;
    }
    public void markAsDone() {
        isDone = true;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public String getTaskType() {
        return "Task";
    }
    public String getTaskDescription() {
        return this.description;
    }
    public LocalDate getTime() {return null;}
    public String getTaskTime() {
        return "";
    }
    public String toString() {
        return ("[" + getStatusIcon() + "] " + description);
    }

    @Override
    public int compareTo(Task o) {
        return 0;
    }
}
