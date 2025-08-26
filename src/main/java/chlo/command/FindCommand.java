package chlo.command;

import chlo.exception.*;
import chlo.storage.*;
import chlo.task.*;
import chlo.ui.*;

public class FindCommand extends Command {
    protected String s;
    public FindCommand(String s){
        this.s = s;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showFilteredList(tasks, s);
    }
}