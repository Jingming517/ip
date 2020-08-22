public class Task {
    public String taskName;
    public boolean taskDone;
    //constructors
    public Task() {
        taskName = "";
        taskDone = false;
    }
    public Task(String taskInput){
        taskName = taskInput;
        taskDone = false;
    }
    public void markAsDone() {
        taskDone = true;
    }
    public String getStatusIcon() {
        return (taskDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
}