package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class CreateCommand extends Command{
	public CreateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER : 
			System.out.println("--CreateCommand execute MEMBER--");
			MemberBean member = new MemberBean();
			member.setMemberId(request.getParameter("userid"));
			member.setName(request.getParameter("username"));
			member.setPassword(request.getParameter("password"));
			member.setSsn(request.getParameter("userssn"));
			
			if(!MemberServiceImpl.getInstance().findByUser(member)) {
				System.out.println("가입된 계정이 있습니다.");
			}else if(!MemberServiceImpl.getInstance().findByOverlabId(member.getMemberId())) {
				System.out.println("중복되는 아이디 입니다.");
			}else {
				System.out.println("환영합니다.");
				MemberServiceImpl.getInstance().createMember(member);
			}
			break;
		default : break;
		}
		super.execute();
	}
}
