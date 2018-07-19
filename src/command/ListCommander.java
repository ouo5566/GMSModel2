package command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class ListCommander extends Command{
	public ListCommander(HttpServletRequest request) {
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
			List<MemberBean> list = MemberServiceImpl.getInstance().list();
			System.out.println("--List execute--");
			System.out.println("List size : "+list.size());
			break;
		default:
			break;
		}
		super.execute();
	}
}
