package command;

public class DeleteCommand extends Command{
	public DeleteCommand(String domain, String action, String page) {
		setDomain(domain);
		setAction(action);
		setPage(page);
		execute();
	}
}
