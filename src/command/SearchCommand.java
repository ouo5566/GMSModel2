package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class SearchCommand extends Command{
	public SearchCommand(HttpServletRequest request) {
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
			System.out.println("--Search execute--");
			List<MemberBean> list = MemberServiceImpl.getInstance().findByTeamId(request.getParameter("team-id"));
			System.out.println("team-list-size : "+list.size());
			break;
		default:
			break;
		}
		super.execute();
	}
}
