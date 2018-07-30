package command;

import javax.servlet.http.HttpServletRequest;

import dao.MemberDAOImpl;
import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class UpdateCommand extends Command{
	public UpdateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		System.out.println("=execute start=");
		execute();
		System.out.println("=execute end=");
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			MemberBean m = (MemberBean) request.getSession().getAttribute("user");
			System.out.println("변경 전\n"+m);
			MemberBean member = new MemberBean();
			member.setMemberId(m.getMemberId());
			member.setPassword(request.getParameter("password"));
			member.setTeamId(request.getParameter("team"));
			member.setRoll(request.getParameter("roll"));
			System.out.println("변경 후\n"+member);
			MemberDAOImpl.getInstance().updateMember(member);
			request.setAttribute("user", MemberServiceImpl.getInstance().login(member));
			setPage("mypage");
			super.execute();

			/*MemberBean member = (MemberBean) request.getSession().getAttribute("user");
			System.out.println("변경 전\n"+member);
			member.setPassword(request.getParameter("password"));
			member.setTeamId(request.getParameter("team"));
			member.setRoll(request.getParameter("roll"));
			System.out.println("변경 후\n"+member);
			MemberDAOImpl.getInstance().updateMember(member);
			setPage("mypage");
			super.execute();
			System.out.println("세션업데이트확인\n"+request.getSession().getAttribute("user"));*/
			break;
		default: break;
		}
	}
}
