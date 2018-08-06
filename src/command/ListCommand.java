package command;

import java.util.HashMap;
import java.util.Map;

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
		request.setAttribute("beginPage", (request.getParameter("pagenum") == null)?
				"1" : request.getParameter("pagenum"));
		
		String count = MemberServiceImpl.getInstance().memberCount();
		request.setAttribute("countPage", Integer.parseInt(count) / 5);
		request.setAttribute("endPage", (Integer.parseInt(count) / 5 > 5)? 5 :
			Integer.parseInt(count) / 5 + ((Integer.parseInt(count) % 5 == 0)? 0 : 1 ));
		
		Map<String, Object> param = new HashMap<>();
		param.put("beginRow", 1 + 
				((request.getParameter("pagenum") == null) ? 0 : (Integer.parseInt(request.getParameter("pagenum"))-1) * 5));
		param.put("endRow", (int) param.get("beginRow") + 4);
		
		request.setAttribute("list", MemberServiceImpl.getInstance().list(param));
		
		//request.setAttribute("list", MemberServiceImpl.getInstance().list((String) request.getAttribute("beginPage")));
		super.execute();
	}
}
