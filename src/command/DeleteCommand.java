package command;

import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class DeleteCommand extends Command{
	public DeleteCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(getDomain().toUpperCase())) {
		case MEMBER:
			System.out.println("DELETE COMMAND");
			// 원칙대로라면 new MemberBean()을 통해 필요한 값만 담아 던진다. 바로 session을 던지지는 않는다.
			MemberServiceImpl.getInstance().removeMember((MemberBean) request.getSession().getAttribute("user"));
			System.out.println("==삭제할 계정==\n"+(MemberBean) request.getSession().getAttribute("user"));
			request.getSession().invalidate(); // 세션의 값을 초기화함. 로그아웃.
			System.out.println("계정이 삭제되었습니다.\n"+(MemberBean) request.getSession().getAttribute("user"));
			break;
		default: break;
		}
		super.execute();
	}
}
