import java.io.IOException;

public class Chlo {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Chlo(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (ChloException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        ui.showTaskList(tasks);
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parseInput(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (ChloException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Chlo("src/main/tasks.txt").run();
    }
}
