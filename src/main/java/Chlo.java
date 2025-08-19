import java.util.Scanner;

public class Chlo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "-".repeat(50);
        System.out.println(line + "\nHello! I'm Chlo\nWhat can I do for you?\n" + line);

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println(line + "\nBye. Hope to see you again soon!\n" + line);
                break;
            }
            System.out.println(line + "\n" + input + "\n" + line);
        }

        scanner.close();
    }
}
