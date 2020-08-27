public class ToDo extends Task {

    public ToDo(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String returnTask() {
        return ("[T]["
                + super.getStatusIcon()
                + "] "
                + super.description);
    }
}