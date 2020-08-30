package tasks;

public class Task {
    public String description;
    public boolean isDone;

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
    public String toString() {
        return ("[" + getStatusIcon() + "] " + description);
    }
}
