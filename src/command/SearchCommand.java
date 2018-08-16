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
		execute();
	}
	
	@Override
	public void execute() {
		Map<String, Object> param = new HashMap<>();
		Proxy p = new PageProxy();
		String pNum = request.getParameter("pagenum");
		String option = request.getParameter("option");
		String word = request.getParameter("word");
		String sOpt = (request.getSession().getAttribute("opt") == null) ? "" : request.getSession().getAttribute("opt").toString();
		String sWord = (request.getSession().getAttribute("w") == null) ? "" : request.getSession().getAttribute("w").toString();
		String sel = (request.getParameter("select") == null) ? "" : request.getParameter("select");
		
		if(sel.equals("all")) {
			if(option == null && sOpt != null) {
				option = sOpt;
				word = sWord;
			} 
		}
		
		param.put("pageNum", (pNum == null) ? 1 : pNum);
		param.put("column", (option == null) ? "" : option);
		param.put("value",  "%" + word + "%");
		param.put("countRow", MemberServiceImpl.getInstance().count(param));
		
		p.carryOut(param);
		Pagination page = (Pagination) ((PageProxy) p).getP();
		
		param.put("endRow", page.getEndRow());
		param.put("beginRow", page.getBeginRow());
		
		request.setAttribute("page", page);
		request.setAttribute("list", MemberServiceImpl.getInstance().search(param));
		
		request.getSession().setAttribute("opt", option);
		request.getSession().setAttribute("w", word);
		super.execute();
	}
}

