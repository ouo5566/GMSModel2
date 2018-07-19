package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command{
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch(Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
			case MEMBER :
				System.out.println("--Retrieve execute--");
				MemberBean member = MemberServiceImpl.getInstance().findById(request.getParameter("member-id"));
				System.out.println("member-name : "+member.getName());
				break;
			default : break;
		}
		super.execute();
	}
}
