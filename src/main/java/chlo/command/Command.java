package chlo.command;

import chlo.storage.*;
import chlo.task.*;
import chlo.ui.*;
/**
 * Represents an abstract command class that gives template of all task classes.
 * Task classes: Event, Todo, Deadline
 */
public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage);

    public boolean isExit() { return false; }
}


