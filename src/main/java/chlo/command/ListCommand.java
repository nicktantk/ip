package chlo.command;

import chlo.storage.*;
import chlo.task.*;
import chlo.ui.*;
import chlo.exception.*;

public class ListCommand extends Command{
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showTaskList(tasks);
    }
}
