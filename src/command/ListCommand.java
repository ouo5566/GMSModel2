package command;

import javax.servlet.http.HttpServletRequest;
import service.MemberServiceImpl;

public class ListCommand extends Command{
	public ListCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		String count = MemberServiceImpl.getInstance().memberCount();
		request.setAttribute("count", Integer.parseInt(count)/5 + ((Integer.parseInt(count)%5 == 0)? 0 : 1 ));
		request.setAttribute("list", MemberServiceImpl.getInstance().list());
		super.execute();
	}
}
