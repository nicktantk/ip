import java.time.LocalDateTime;

public class Deadline extends Task {

    protected LocalDateTime by;

    public Deadline(String description, String by) {
        super(description);
        this.by = DateParser.parseDeadline(by);
        this.raw = String.format("deadline %s /by %s", description, by);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + DateParser.getFormattedDeadline(this.by) + ")";
    }
}
