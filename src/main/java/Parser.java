import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Parser {
    public static Command parseInput(String input) throws ChloException {
        // Split and identify command
        if (input.equals("bye")) {
            return new ExitCommand();
        } else if (input.equals("list")) {
            return new ListCommand();
        } else if (input.startsWith("todo") || input.startsWith("deadline") || input.startsWith("event")) {
            return new AddCommand(input);
        } else if (input.startsWith("delete")) {
            return new DeleteCommand(input.substring(7).trim());
        } else if (input.startsWith("mark")) {
            return new MarkCommand(input.substring(5).trim());
        } else if (input.startsWith("unmark")) {
            return new UnmarkCommand(input.substring(7).trim());
        }else {
            throw new ChloException("Unrecognised message");
        }
    }

    public static LocalDateTime parseDate(String input) throws ChloException{
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
            return LocalDateTime.parse(input, formatter);
        } catch (DateTimeParseException e) {
            throw new ChloException("Invalid date format.\nDates in DD/MM/YYYY HHmm");
        }
    }
    public static String getFormattedDate(LocalDateTime by) {
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("d'suffix' 'of' MMMM yyyy, h:mma");
        return by.format(outputFormatter).replace("suffix", getDaySuffix(by.getDayOfMonth()));
    }

    private static String getDaySuffix(int day) {
        return switch (day) {
            case 1, 21, 31 -> "st";
            case 2, 22 -> "nd";
            case 3, 23 -> "rd";
            default -> "th";
        };
    }
}
