package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		MemberBean member = new MemberBean();
		member.setMemberId(request.getParameter("userid"));
		member.setPassword(request.getParameter("password"));
		if(MemberServiceImpl.getInstance().loginFlag(member)) {
			// Attribute 는 key와 value로 처리를 하며, 이 것을 mapping이라고 한다. 사상구조로 내부는 무한하다. (extends HashMap)
			// key값만 unique하면 무한대로(메모리용량) 값을 적재할 수 있다.
			// JSP -> request(action="*.do":주소지, parameter:값) -> Servlet
			// JSP <- request(Attribute) <- Servlet
			request.setAttribute("match", "TRUE");
			System.out.println(MemberServiceImpl.getInstance().login(member));
			request.setAttribute("user", MemberServiceImpl.getInstance().login(member));
		}else {
			request.setAttribute("match", "FALSE");
		}
		super.execute();
	}
}
