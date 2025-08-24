public class MarkCommand extends Command {
    private String index;
    public MarkCommand(String index) {
        this.index = index;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            int i =  Integer.parseInt(index) - 1;
            Task task = tasks.get(i);
            task.markDone();
            ui.showMarkTask(task);
        } catch (ChloException e) {
            ui.showError(e.getMessage());
        }
    }
}
