package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import proxy.*;
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
		Proxy p = new PageProxy();
		String pNum = request.getParameter("pagenum");
		p.carryOut((pNum == null)? 1 : pNum);
		Pagination page = (Pagination) ((PageProxy) p).getP();
		Map<String, Object> param = new HashMap<>();
		param.put("endRow", page.getEndRow());
		param.put("beginRow", page.getBeginRow());
		param.put("column", request.getParameter("option"));
		param.put("word", "%" + request.getParameter("word") + "%");
		
		request.setAttribute("page", page);
		request.setAttribute("list", MemberServiceImpl.getInstance().search(param));
		
		super.execute();
	}
}

