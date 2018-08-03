package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
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
		String count = String.valueOf(((List<MemberBean>) request.getAttribute("list")).size());
		request.setAttribute("count", Integer.parseInt(count)/5 + ((Integer.parseInt(count)%5 == 0)? 0 : 1 ));
		super.execute();
	}
}
