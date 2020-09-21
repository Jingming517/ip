package duke.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    protected LocalDate time;

    public Event(String description, boolean isDone, LocalDate time) {
        super(description, isDone);
        this.time = time;
    }

    @Override
    public String getTaskType() {
        return "E";
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
        return "[E]"
                + super.toString()
                + " (at: "
                + time.format(DateTimeFormatter.ofPattern("MMM d yyyy"))
                + ")";
    }

}