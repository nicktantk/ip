package chlo;

import chlo.command.*;
import chlo.storage.*;
import chlo.task.*;
import chlo.ui.*;
import chlo.exception.*;

public class Chlo {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private String commandType;

    public Chlo(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (ChloException e) {
            // ui.LoadingError();
            tasks = new TaskList();
        }
    }

    public String getResponse(String input) {
        try {
            Command c = Parser.parseInput(input);
            c.execute(tasks, ui, storage);
            this.commandType = c.getClass().getSimpleName();
            return c.getString();
        } catch (ChloException e) {
            return "Error: " + e.getMessage();
        }
    }

    public String getCommandType() {
        return this.commandType;
    }
}



