package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {
	public static void send(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("view : "+Sentry.cmd.getView());
		request.getRequestDispatcher(Sentry.cmd.getView()).forward(request, response);
	}
}
