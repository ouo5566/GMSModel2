package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class ListCommand extends Command{
	protected List<MemberBean> list;
	public ListCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		System.out.println("ListCommandDomain : "+getDomain());
		System.out.println("ListCommandAction : "+getAction());
		System.out.println("ListCommandPage : "+getPage());
		execute();
	}
	
	@Override
	public void execute() {
		System.out.println("--Sentry Cmd--");
		System.out.println(Sentry.cmd.getDomain());
		System.out.println(Sentry.cmd.getAction());
		System.out.println(Sentry.cmd.getPage());
		System.out.println("SentryCmdDomain : " + Sentry.cmd.domain);
		switch (Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER:
			this.list = MemberServiceImpl.getInstance().list();
			System.out.println("--List execute--");
			break;
		default:
			break;
		}
		super.execute();
	}
	
	public List<MemberBean> getList() {
		return list;
	}
	
}
