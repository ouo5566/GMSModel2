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
		switch (Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER:
			MemberBean member = new MemberBean();
			member.setMemberId(request.getParameter("userid"));
			member.setName(request.getParameter("username"));
			member.setPassword(request.getParameter("password"));
			member.setSsn(request.getParameter("userssn"));
			System.out.println("어서오세요");
			if(MemberServiceImpl.getInstance().login(member)) {
				System.out.println("어서오세요");
			}else {
				System.out.println("아이디 혹은 비밀번호가 정확하지 않습니다.");
			}
			break;
		default:
			break;
		}
		super.execute();
	}
}
