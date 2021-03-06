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
		int pageSize = 5 , blockSize = 5,
				pGap = pageSize - 1,
				bGap = blockSize - 1,
				countRow = Integer.parseInt(MemberServiceImpl.getInstance().memberCount()),
				countPage = countRow / pageSize + ((countRow % pageSize == 0) ? 0 : 1 ), // 총 페이지
				pageNum = (request.getParameter("pagenum") == null)? 1 
						: Integer.parseInt(request.getParameter("pagenum")),
				block = (request.getParameter("block") == null)?
						(pageNum + pGap) / pageSize
						: Integer.parseInt(request.getParameter("block")),
				nextPage = ((countPage - block * blockSize > 0))? countPage - block * blockSize : 0, // 잔여페이지
				prevPage = (pageNum - pageSize > 0)? pageNum - pageSize : 0 ; // 이전페이지
		
		request.setAttribute("nextPage", (nextPage > 0)); 
		request.setAttribute("prevPage", (prevPage > 0));
		request.setAttribute("endPage", (nextPage > blockSize) ? block * blockSize : countPage );
		request.setAttribute("beginPage", block * blockSize - bGap);
		
		Map<String, Object> param = new HashMap<>();
		param.put("endRow", String.valueOf(pageNum * pageSize));
		param.put("beginRow", String.valueOf(pageNum * pageSize - pGap));
		
		request.setAttribute("list", MemberServiceImpl.getInstance().list(param));
		//request.setAttribute("list", MemberServiceImpl.getInstance().list((String) request.getAttribute("beginPage")));
		super.execute();
	}
}
