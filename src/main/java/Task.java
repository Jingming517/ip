public class Task {
    public String taskName;
    public boolean isDone;
    //constructors
    public Task() {
        taskName = "";
        isDone = false;
    }
    public Task(String taskInput){
        taskName = taskInput;
        isDone = false;
    }
    public void markAsDone() {
        isDone = true;
    }
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or cross symbols
    }
}