package command;

import javax.servlet.http.HttpServletRequest;

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
			// 원칙대로면 tomcat의 영역인 servlet에서 session에 값을 담고 수정해야한다.
			// session은 request가 있는 곳이면 따라다니기 때문에 Command 화면에서도 호출하여 값을 담는게 가능하다.
			
			/* session을 호출하지 않고 값을 담아보기
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
			super.execute();*/

			MemberBean member = (MemberBean) request.getSession().getAttribute("user");
			System.out.println("변경 전\n"+member);
			member.setPassword(request.getParameter("password"));
			member.setTeamId(request.getParameter("team"));
			member.setRoll(request.getParameter("roll"));
			System.out.println("변경 후\n"+member);
			MemberServiceImpl.getInstance().modifyMember(member);
			setPage("mypage");
			super.execute();
			System.out.println("세션업데이트확인\n"+request.getSession().getAttribute("user"));
			break;
		default: break;
		}
	}
}
