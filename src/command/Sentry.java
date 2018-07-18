package command;

import javax.servlet.http.HttpServletRequest;
// 보초, information의 느낌. 처음 실행되어 자기가 맡은 일만 수행한다.
public class Sentry {
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request) {
		String servletPath = request.getServletPath(); //여기서는 통일한 ServletPath 인 /member.do
		System.out.println("센트리 : " + servletPath.substring(1, servletPath.indexOf("."))); // 센트리 : member -> domain
		System.out.println("액션 : "+request.getParameter("action"));
		System.out.println("페이지 : "+request.getParameter("page"));
		cmd = Commander.order(servletPath.substring(1, servletPath.indexOf(".")), request.getParameter("action"), request.getParameter("page"));
		// action 과 page 의 값을 전달하고서는 끝.
	}
}
