package command;

import javax.servlet.http.HttpServletRequest;
import enums.Columns;
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
		request.setAttribute("list", MemberServiceImpl.getInstance().findByWord(
				Columns.valueOf(request.getParameter("option").toUpperCase()), request.getParameter("word")));
		super.execute();
	}
}
