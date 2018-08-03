package command;

import javax.servlet.http.HttpServletRequest;
import enums.Action;

public class Commander{
	public static Command order(HttpServletRequest request) {
		Command cmd = null;
		switch(Action.valueOf(request.getParameter("action").toUpperCase())) {
		case MOVE :
			cmd = new MoveCommand(request);
			break;
		case JOIN :
			cmd = new CreateCommand(request);
			break;
		case UPDATE :
			cmd = new UpdateCommand(request);
			break;
		case DELETE : 
			cmd = new DeleteCommand(request);
			break;
		case LOGIN : 
			cmd = new LoginCommand(request);
			break;
		case LIST :
			System.out.println("==LIST==");
			cmd = new ListCommand(request);
			break;
		case SEARCH :
			System.out.println("==SEARCH==");
			cmd = new SearchCommand(request);
			break;
		case RETRIEVE :
			cmd = new RetrieveCommand(request);
			break;
		case COUNT :
			cmd = new CountCommand(request);
			break;
		}
		return cmd;
	}
}
