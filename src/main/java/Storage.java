import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> load() throws ChloException {
        try {
            ArrayList<Task> tasks = new ArrayList<>();
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("todo")) {
                    tasks.add(new Todo(line.substring(5).trim()));
                } else if (line.startsWith("deadline")) {
                    int i = line.indexOf("/by");
                    tasks.add(new Deadline(line.substring(9, i).trim(), line.substring(i+4).trim()));
                } else {
                    int i = line.indexOf("/from");
                    int j = line.indexOf("/to");
                    tasks.add(new Event(line.substring(6, i).trim(), line.substring(i + 6, j).trim(), line.substring(j + 4).trim()));
                }
            }
            scanner.close();
            return tasks;
        } catch (IOException e) {
            throw new ChloException("Error loading file.");
        }
    }

    public void save(TaskList tasks) {
        try {
            FileWriter fw = new FileWriter(filePath);
            for (int i = 0; i < tasks.size(); i++) {
                fw.write(tasks.get(i).getRaw() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }
}
