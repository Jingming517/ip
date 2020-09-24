package duke.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    protected LocalDate time;

    public Deadline(String description, Boolean isDone, LocalDate time) {
        super(description, isDone);
        this.time = time;
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
    public LocalDate getTime() {
        return this.time;
    }

    @Override
    public String getTaskTime() {
        return time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public String toString() {
        return "[D]"
                + super.toString()
                + " (by: "
                + time.format(DateTimeFormatter.ofPattern("MMM d yyyy"))
                + ")";
    }

}