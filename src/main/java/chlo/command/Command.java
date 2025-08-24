package chlo.command;

import chlo.ui.*;
import chlo.storage.*;
import chlo.task.*;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage);

    public boolean isExit() { return false; }
}



// Implement chlo.command.AddCommand, chlo.command.DeleteCommand, chlo.command.ListCommand etc. similarly
