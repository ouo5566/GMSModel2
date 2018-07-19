package command;

import javax.servlet.http.HttpServletRequest;
import enums.Action;

public class Commander{
	public static Command order(HttpServletRequest request) {
		Command cmd = null;
		switch(Action.valueOf(request.getParameter("action").toUpperCase())) {
		case MOVE :
			System.out.println("--Commander_move--");
			cmd = new MoveCommand(request);
			break;
		case JOIN :
			System.out.println("--Commander_join--");
			cmd = new CreateCommand(request);
			break;
		case UPDATE :
			System.out.println("--Commander_update--");
			cmd = new UpdateCommand(request);
			break;
		case DELETE : 
			System.out.println("--Commander_delete--");
			cmd = new DeleteCommand(request);
			break;
		case LOGIN : 
			System.out.println("--Commander_login--");
			cmd = new LoginCommand(request);
			break;
		case LIST :
			System.out.println("--Commander list--");
			cmd = new ListCommander(request);
			break;
		case SEARCH :
			System.out.println("--Commander search--");
			cmd = new SearchCommand(request);
			break;
		case RETRIEVE :
			System.out.println("--Commander retrieve--");
			cmd = new RetrieveCommand(request);
			break;
		default:
			break;
		}
		return cmd;
	}
}
