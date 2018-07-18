package command;

import enums.Action;

public class Commander{
	public static Command order(String domain, String action, String page) {
		Command cmd = null;
		switch(Action.valueOf(action.toUpperCase())) {
		case MOVE :
			System.out.println("--Commander_move--");
			cmd = new MoveCommand(domain, action, page);
			break;
		case JOIN :
			System.out.println("--Commander_join--");
			cmd = new MoveCommand(domain, action, page);
			break;
		case UPDATE :
			System.out.println("--Commander_update--");
			cmd = new MoveCommand(domain, action, page);
		case DELETE : 
			System.out.println("--Commander_delete--");
			cmd = new MoveCommand(domain, action, page);
		case LOGIN : 
			System.out.println("--Command_login--");
			cmd = new MoveCommand(domain, action, page);
		default:
			break;
		}
		return cmd;
	}
}
