public class Event extends Task {

    protected String at;

    public Event(String description, boolean isDone, String at) {
        super(description, isDone);
        this.at = at;
    }

    @Override
    public String returnTask() {
        return ("[E]["
                + super.getStatusIcon()
                + "] "
                + super.description
                + " (by: "
                + this.at
                + ")");
    }
}