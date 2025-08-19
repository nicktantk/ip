import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Chlo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks =  new ArrayList<>();
        String line = "-".repeat(50);
        System.out.println(line + "\nHello! I'm Chlo\nWhat can I do for you?\n" + line);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                System.out.println(line + "\nBye. Hope to see you again soon!\n" + line);
                break;
            } else if (input.equals("list")) {
                System.out.println(line);
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i+1) + ". " + tasks.get(i));
                }
                System.out.println(line);
            } else {
                tasks.add(input);
                System.out.println(line + "\nadded: " + input + "\n" + line);
            }
        }

        scanner.close();
    }
}
