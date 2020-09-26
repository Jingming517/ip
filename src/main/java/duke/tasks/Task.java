package duke.tasks;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * Encapsulates a Task object.
 */
public class Task {
    public String description;
    public boolean isDone;
    public LocalDate time;

    public Task() {
        description = "";
        isDone = false;
    }

    /**
     * Constructs a task object.
     * @param taskInput task description.
     * @param status task status.
     */
    public Task(String taskInput, boolean status){
        description = taskInput;
        isDone = status;
        time = null;
    }

    /**
     * Marks a task status as done.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Gets the task status.
     * @return the task status icon.
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Gets the type of task.
     * @return [Task,T, D, E]
     */
    public String getTaskType() {
        return "Task";
    }

    /**
     * Gets the description of task
     * @return task description.
     */
    public String getTaskDescription() {
        return this.description;
    }

    public LocalDate getTime() {return null;}

    public String getTaskTime() {
        return "";
    }

    public LocalDate getDateTime() {
        return time;
    }

    /**
     * Converts task type, status, description and date to a string.
     * @return a string of task information.
     */
    public String toString() {
        return ("[" + getStatusIcon() + "] " + description);
    }

}
