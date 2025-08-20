import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Chlo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task[] tasks =  new Task[100];
        int count = 0;
        String line = "-".repeat(50);
        System.out.println(line + "\nHello! I'm Chlo\nWhat can I do for you?\n" + line);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                System.out.println(line + "\nBye. Hope to see you again soon!\n" + line);
                break;
            } else if (input.equals("list")) {
                System.out.println(line);
                System.out.println("Here are the tasks in your list:\n");
                for (int i = 0; i < count; i++) {
                    System.out.println((i+1) + ". " + tasks[i].toString());
                }
                System.out.println(line);
            } else if (input.equals("todo") || input.equals("deadline") || input.equals("event")) {
                System.out.printf(line + "\nDescription of %s cannot be empty.\n" + line + "\n", input);
            }else if (input.startsWith("todo")) {
                tasks[count++] = new Todo(input.substring(5));
                System.out.println(line + "\nGot it. I've added this task:\n" + tasks[count-1].toString() + "\nNow you have " + count + " tasks in the list.\n" + line);
            } else if (input.startsWith("deadline")) {
                int by = input.indexOf("/by");
                tasks[count++] = new Deadline(input.substring(9, by-1), input.substring(by+4));
                System.out.println(line + "\nGot it. I've added this task:\n" + tasks[count-1].toString() + "\nNow you have " + count + " tasks in the list.\n" + line);
            } else if (input.startsWith("event")) {
                int from = input.indexOf("/from");
                int to = input.indexOf("/to");
                tasks[count++] = new Event(input.substring(6, from-1), input.substring(from+6, to-1), input.substring(to+4));
                System.out.println(line + "\nGot it. I've added this task:\n" + tasks[count-1].toString() + "\nNow you have " + count + " tasks in the list.\n" + line);
            } else if (input.startsWith("mark")) {
                int i = Integer.parseInt(input.split(" ")[1]);
                tasks[i-1].markDone();
                System.out.println(line + "\nNice! I've marked this task as done:\n" + tasks[i-1].toString() + "\n" + line);
            } else if (input.startsWith("unmark")) {
                int i = Integer.parseInt(input.split(" ")[1]);
                tasks[i-1].markUndone();
                System.out.println(line + "\nOK, I've marked this task as not done yet:\n" + tasks[i-1].toString() + "\n" + line);

            } else {
                System.out.println(line + "\nUnrecognised message\n" + line);
            }
        }

        scanner.close();
    }
}
