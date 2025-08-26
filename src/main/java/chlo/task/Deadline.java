package chlo.task;

import chlo.exception.ChloException;
import chlo.ui.Parser;

import java.time.LocalDateTime;

public class Deadline extends Task {

    protected LocalDateTime by;

    public Deadline(String description, String by) throws ChloException {
        super(description);

        this.by = Parser.parseDate(by);
        this.raw = String.format("deadline %s /by %s", description, by);

    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + Parser.getFormattedDate(this.by) + ")";
    }
}
