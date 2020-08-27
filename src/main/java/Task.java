public class Task {
    public String description;
    public boolean isDone;

    //constructors
    public Task() {
        description = "";
        isDone = false;
    }
    public Task(String taskInput, boolean status){
        description = taskInput;
        isDone = status;
    }

    //methods
    public void markAsDone() {
        isDone = true;
    }
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
        //return tick or cross symbols
    }
    public String returnTask() {
        return ("\t   ["
                + getStatusIcon()
                + "] "
                + description);
    }
}
