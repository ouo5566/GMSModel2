package command;

import javax.servlet.http.HttpServletRequest;

import domain.*;
import enums.Action;
import service.*;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		request.getSession().setAttribute("match", "FALSE");
		switch(Action.valueOf(request.getParameter("log").toUpperCase())) {
			case LOGIN :
				MemberBean member = new MemberBean();
				member.setMemberId(request.getParameter("userid"));
				member.setPassword(request.getParameter("password"));
				if(MemberServiceImpl.getInstance().loginFlag(member)) {
					request.getSession().setAttribute("match", "TRUE" );
					request.getSession().setAttribute("user", MemberServiceImpl.getInstance().login(member));
					ImageBean pf = ImageServiceImpl.getInstance().searchOne(
							((MemberBean)request.getSession().getAttribute("user")).getMemberId());
					request.getSession().setAttribute("profile",
							(pf == null) ?
									"/mypage/vanilla.jpg"	:
										String.format("/upload/%s.%s", pf.getImgName(), pf.getExtension()));
				}
				break;
			case LOGOUT : 
				request.getSession().invalidate();
				request.getSession().setAttribute("match", "FALSE");
				System.out.println("logout");
				break;
			default:break;
		}
 		super.execute();
	}
}
