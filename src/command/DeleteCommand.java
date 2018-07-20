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
			String userPW = request.getParameter("userpw");
			String confirmPW = request.getParameter("confirm-pw");
			MemberBean member = new MemberBean();
			member.setMemberId(request.getParameter("userid"));
			member.setPassword(userPW);
			if(userPW.equals(confirmPW) && MemberServiceImpl.getInstance().loginFlag(member)) {
			MemberServiceImpl.getInstance().removeMember(member);
			System.out.println("계정이 삭제되었습니다.");
			}
			break;
		default: break;
		}
		super.execute();
	}
}
