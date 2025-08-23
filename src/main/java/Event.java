import java.time.LocalDateTime;

public class Event extends Task {

    protected LocalDateTime from;
    protected LocalDateTime to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = DateParser.parseDeadline(from);
        this.to = DateParser.parseDeadline(to);
        this.raw = String.format("event %s /from %s /to %s", description, from, to);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + DateParser.getFormattedDeadline(this.from) + " to: " + DateParser.getFormattedDeadline(this.to) + ")";
    }
}
