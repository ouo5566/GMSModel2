package command;

import enums.Action;

public class Commander{
	public static Command order(String domain, String action, String page) {
		Command cmd = null;
		switch(Action.valueOf(action)) {
		case MOVE :
			System.out.println("--move--");
			cmd = new MoveCommand(domain, action, page);
			break;
		}
		return cmd;
	}
}
