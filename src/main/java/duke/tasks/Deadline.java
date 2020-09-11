package duke.tasks;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, Boolean isDone, String by) {
        super(description, isDone);
        this.by = by;
    }

    @Override
    public String getTaskType() {
        return "D";
    }

    @Override
    public String getTaskDescription() {
        return this.description;
    }

    @Override
    public String getTaskTime() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}