package duke.tasks;

public class Todo extends Task {

    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String getTaskType() {
        return "T";
    }

    @Override
    public String getTaskDescription() {
        return this.description;
    }

    @Override
    public String getTaskTime() {
        return "";
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}