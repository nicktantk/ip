package chlo.command;

import chlo.exception.*;
import chlo.storage.*;
import chlo.task.*;
import chlo.ui.*;

/**
 * Represents an exit command when the user closes the app.
 * Initiated by the input "bye".
 */
public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showLine();
        System.out.println("Bye. Hope to see you again soon!");
        ui.showLine();
    }
    @Override
    public boolean isExit() { return true; }
}