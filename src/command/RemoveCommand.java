package command;

import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class RemoveCommand extends Command{
	public RemoveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(getDomain().toUpperCase())) {
		case MEMBER:
			System.out.println("DELETE COMMAND");
			MemberServiceImpl.getInstance().remove((MemberBean) request.getSession().getAttribute("user"));
			request.getSession().invalidate(); // 세션의 값을 초기화함. 로그아웃.
			break;
		default: break;
		}
		super.execute();
	}
}
