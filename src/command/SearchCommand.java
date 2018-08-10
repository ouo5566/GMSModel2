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
		
		System.out.println(sOpt);
		System.out.println(sWord);
		
		if(sOpt == null || ( sOpt != null && option != null ) ) {
			System.out.println("1");
			option = request.getParameter("option");
			word = request.getParameter("word");
		}else if(option == null) {
			System.out.println("2");
			option = sOpt;
			word = sWord;
		}
		System.out.println("3");
		
		System.out.println(option);
		System.out.println(word);
		
		
		/* 처음 검색할 경우 Session 은 비어있는 상태
		 * Session 이 비어있을 경우 String 에 각각 Parameter 의 값을 핟당
		 * 검색결과의 페이지를 누르면 Session 의 값은 있지만 Parameter 의 값이 비어있는 상태
		 * Session 이 있고 Param 의 값이 없으면 String 에 Session 의 값을 할당
		 * Session 이 있고 Param 의 값이 있으면 String 에 Param 의 값을 할당
		 * Session 이 없으면 String 에 Param 의 값을 할당 
		 * */
		
		
		
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

