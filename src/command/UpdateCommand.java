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
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER:
			String pw = request.getParameter("userpw");
			String newPW = request.getParameter("new-userpw");
			MemberBean member = new MemberBean();
			member.setMemberId(request.getParameter("userid"));
			member.setPassword(pw);
			if(!pw.equals(newPW) && MemberServiceImpl.getInstance().login(member)) {
				member.setPassword(pw+"/"+newPW);
				MemberServiceImpl.getInstance().modifyMember(member);
				System.out.println("비밀번호가 변경되었습니다.");
			}else {System.out.println("비밀번호가 정확하지 않습니다.");}
			break;
		default: break;
		}
		super.execute();
	}
}
