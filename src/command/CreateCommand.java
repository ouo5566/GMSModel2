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
			MemberBean member = new MemberBean();
			member.setMemberId(request.getParameter("userid"));
			member.setName(request.getParameter("username"));
			member.setPassword(request.getParameter("password"));
			member.setSsn(request.getParameter("userssn"));
			member.setAge(request.getParameter("age"));
			member.setGender(request.getParameter("gender"));
			member.setTeamId(request.getParameter("teamid"));
			member.setRoll(request.getParameter("roll"));
			member.setSubject(ParamMap.getValues(request, "subject"));
			MemberServiceImpl.getInstance().createMember(member);
			break;
		default : break;
		}
		super.execute();
	}
}
