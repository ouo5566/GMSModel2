package command;

import javax.servlet.http.HttpServletRequest;
// 보초, information의 느낌. 처음 실행되어 자기가 맡은 일만 수행한다.
public class Sentry {
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request) {
		cmd = Commander.order(request);
	}
}
