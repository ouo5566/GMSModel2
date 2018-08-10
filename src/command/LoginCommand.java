package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		MemberBean member = new MemberBean();
		member.setMemberId(request.getParameter("userid"));
		member.setPassword(request.getParameter("password"));
		if(MemberServiceImpl.getInstance().loginFlag(member)) {
			request.setAttribute("match", "TRUE");
			request.getSession().setAttribute("user", MemberServiceImpl.getInstance().login(member));
		}else {
			request.setAttribute("match", "FALSE");
		}
		super.execute();
	}
}
