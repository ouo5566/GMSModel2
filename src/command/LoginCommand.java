package command;

import javax.servlet.http.HttpServletRequest;

import domain.*;
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
			MemberBean member = new MemberBean();
			member.setMemberId(request.getParameter("userid"));
			member.setPassword(request.getParameter("password"));
			if(MemberServiceImpl.getInstance().loginFlag(member)) {
				request.setAttribute("match", "TRUE");
				request.getSession().setAttribute("user", MemberServiceImpl.getInstance().login(member));
				ImageBean pf = ImageServiceImpl.getInstance().searchOne(
						((MemberBean)request.getSession().getAttribute("user")).getMemberId());
				System.out.println(pf);
				request.setAttribute("profile",
						(pf == null) ?
							"/mypage/vanilla.jpg"	:
								String.format("/upload/%s.%s", pf.getImgName(), pf.getExtension()));
			}else {
				request.setAttribute("match", "FALSE");
			}
/*		if(request.getSession().getAttribute("user") == null) {
		}else {
			request.getSession().invalidate();
			System.out.println("logout");
		}
*/		super.execute();
	}
}
