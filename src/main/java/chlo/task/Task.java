package chlo.task;

public class Task {
    protected String raw;
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markDone() {
        isDone = true;
    }

    public void markUndone() {
        isDone = false;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public String getRaw() {
        return raw;
    }

    public String getDescription() {
        return description;
    }
}
