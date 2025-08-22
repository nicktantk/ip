public class Task {
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

    public static Task parseTask(String line) {
        char type = line.charAt(1);       // Get T, D, or E from [T], [D], or [E]
        boolean isDone = line.charAt(4) == 'X';  // Check done status [X] or [ ]

        switch (type) {
            case 'T': {
                // Todo format: [T][X] description
                String description = line.substring(7);
                Todo todo = new Todo(description);
                if (isDone) {
                    todo.markDone();
                }
                return todo;
            }
            case 'D': {
                // Deadline format: [D][ ] description (by: date)
                // Extract description and by date between known parentheses
                int byIndex = line.lastIndexOf("(by:");
                String description = line.substring(7, byIndex -1).trim();
                String by = line.substring(byIndex + 5, line.length() - 1).trim(); // Remove closing )

                Deadline deadline = new Deadline(description, by);
                if (isDone) {
                    deadline.markDone();
                }
                return deadline;
            }
            case 'E': {
                // Event format: [E][X] description (from: startDate to: endDate)
                int fromIndex = line.lastIndexOf("(from:");
                int toIndex = line.lastIndexOf("to:");

                String description = line.substring(7, fromIndex -1).trim();
                String from = line.substring(fromIndex + 6, toIndex -1).trim();
                String to = line.substring(toIndex + 3, line.length() - 1).trim();

                Event event = new Event(description, from, to);
                if (isDone) {
                    event.markDone();
                }
                return event;
            }
            default:
                throw new IllegalArgumentException("Unknown task type: " + type);
        }
    }

}
