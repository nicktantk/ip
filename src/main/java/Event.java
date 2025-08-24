import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Event extends Task {

    protected LocalDateTime from;
    protected LocalDateTime to;

    public Event(String description, String from, String to) throws ChloException {
        super(description);
        this.from = Parser.parseDate(from);
        this.to = Parser.parseDate(to);
        this.raw = String.format("event %s /from %s /to %s", description, from, to);

    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + Parser.getFormattedDate(this.from) + " to: " + Parser.getFormattedDate(this.to) + ")";
    }
}
