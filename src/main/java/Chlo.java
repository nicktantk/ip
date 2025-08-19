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
                for (int i = 0; i < count; i++) {
                    System.out.println((i+1) + ". " + tasks[i].toString());
                }
                System.out.println(line);
            } else if (input.startsWith("mark")) {
                int i = Integer.parseInt(input.split(" ")[1]);
                tasks[i-1].markDone();
                System.out.println(line + "\nNice! I've marked this task as done:\n" + tasks[i-1].toString() + "\n" + line);
            } else if (input.startsWith("unmark")) {
                int i = Integer.parseInt(input.split(" ")[1]);
                tasks[i-1].markUndone();
                System.out.println(line + "\nOK, I've marked this task as not done yet:\n" + tasks[i-1].toString() + "\n" + line);

            } else {
                tasks[count++] =  new Task(input);
                System.out.println(line + "\nadded: " + input + "\n" + line);
            }
        }

        scanner.close();
    }
}
