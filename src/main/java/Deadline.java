public class Deadline extends Task {

    protected String by;

    public Deadline(String description, Boolean isDone, String by) {
        super(description, isDone);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
    @Override
    public String returnTask() {
        return ("[D]["
                + super.getStatusIcon()
                + "] "
                + super.description
                + " (by: "
                + this.by
                + ")");
    }
}