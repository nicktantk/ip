import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class Chlo {
    private static final String FILE_PATH = "src/main/tasks.txt";

    // Load tasks from file into ArrayList
    private static ArrayList<Task> displayTasksFromFile() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(FILE_PATH);
        try {
            Scanner scanner = new Scanner(file);
            if (!file.exists()) {
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("Greetings new user. I'm Chlo!");
                } else {
                    System.out.println("Unable to create file, please check permissions.");
                }
            } else if(!scanner.hasNextLine()) {
                System.out.println("Welcome back! I'm Chlo!\nYou are up to date with your tasks.");
            } else {
                System.out.println("Welcome back! I'm Chlo!\nYour current tasks:");
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.startsWith("todo")) {
                        Task task = new Todo(line);
                        tasks.add(task);
                        System.out.println(task.toString());
                    } else if (line.startsWith("deadline")) {
                        int by = line.indexOf("/by");
                        Task task = new Deadline(line.substring(9, by-1), line.substring(by+4));
                        tasks.add(task);
                        System.out.println(task.toString());
                    } else {
                        int from = line.indexOf("/from");
                        int to = line.indexOf("/to");
                        Task task = new Event(line.substring(6, from-1), line.substring(from+6, to-1), line.substring(to+4));
                        System.out.println(task.toString());
                    }
                }
                scanner.close();
            }
        } catch (IOException e) {
            System.out.println("Error accessing tasks file: " + e.getMessage());
        }
        return tasks;
    }


    // Save all tasks to file
    private static void saveTasksToFile(ArrayList<Task> tasks) {
        try (FileWriter fw = new FileWriter(FILE_PATH)) {
            for (Task task : tasks) {
                fw.write(task.toRaw() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = displayTasksFromFile();
        String line = "-".repeat(50);
        System.out.println("What else can I do for you today?\n" + line);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                saveTasksToFile(tasks);  // Save before exiting
                System.out.println(line + "\nBye. Hope to see you again soon!\n" + line);
                break;
            } else if (input.equals("list")) {
                System.out.println(line);
                System.out.println("Here are the tasks in your list:\n");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i+1) + ". " + tasks.get(i).toString());
                }
                System.out.println(line);
            } else if (input.equals("todo") || input.equals("deadline") || input.equals("event")) {
                System.out.printf(line + "\nDescription of %s cannot be empty.\n" + line + "\n", input);
            } else if (input.startsWith("todo")) {
                tasks.add(new Todo(input.substring(5)));
                saveTasksToFile(tasks);
                System.out.println(line + "\nGot it. I've added this task:\n" + tasks.get(tasks.size()-1).toString()
                        + "\nNow you have " + tasks.size() + " tasks in the list.\n" + line);
            } else if (input.startsWith("deadline")) {
                int by = input.indexOf("/by");
                tasks.add(new Deadline(input.substring(9, by-1), input.substring(by+4)));
                saveTasksToFile(tasks);
                System.out.println(line + "\nGot it. I've added this task:\n" + tasks.get(tasks.size()-1).toString()
                        + "\nNow you have " + tasks.size() + " tasks in the list.\n" + line);
            } else if (input.startsWith("event")) {
                int from = input.indexOf("/from");
                int to = input.indexOf("/to");
                tasks.add(new Event(input.substring(6, from-1), input.substring(from+6, to-1), input.substring(to+4)));
                saveTasksToFile(tasks);
                System.out.println(line + "\nGot it. I've added this task:\n" + tasks.get(tasks.size()-1).toString()
                        + "\nNow you have " + tasks.size() + " tasks in the list.\n" + line);
            } else if (input.startsWith("mark")) {
                int i = Integer.parseInt(input.substring(5));
                tasks.get(i-1).markDone();
                saveTasksToFile(tasks);
                System.out.println(line + "\nNice! I've marked this task as done:\n" + tasks.get(i-1).toString() + "\n" + line);
            } else if (input.startsWith("unmark")) {
                int i = Integer.parseInt(input.substring(7));
                tasks.get(i-1).markUndone();
                saveTasksToFile(tasks);
                System.out.println(line + "\nOK, I've marked this task as not done yet:\n" + tasks.get(i-1).toString() + "\n" + line);
            } else if (input.startsWith("delete")) {
                int i = Integer.parseInt(input.substring(7));
                System.out.println(line + "\nNoted. I've removed this task:\n" + tasks.get(i-1).toString());
                tasks.remove(i-1);
                saveTasksToFile(tasks);
                System.out.printf("Now you have %d tasks in the list.\n" + line + "\n", tasks.size());
            } else {
                System.out.println(line + "\nUnrecognised message\n" + line);
            }
        }

        scanner.close();
    }
}
