package proxy;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Pagenation implements Proxy{
	int pageSize, blockSize, pGap, countRow, countPage, pageNum, block, nextPage, prevPage; 
	
	/*int pageSize = 5 ;
	int blockSize = 5;
	int pGap = pageSize - 1;
	int bGap = blockSize - 1;
	int countRow = Integer.parseInt(MemberServiceImpl.getInstance().memberCount());
	int countPage = countRow / pageSize + ((countRow % pageSize == 0) ? 0 : 1 ); // 총 페이지
	int pageNum = (request.getParameter("pagenum") == null)? 1 	: Integer.parseInt(request.getParameter("pagenum"));
	int block = (request.getParameter("block") == null)? (pageNum + pGap) / pageSize
					: Integer.parseInt(request.getParameter("block"));
	int nextPage = ((countPage - block * blockSize > 0))? countPage - block * blockSize : 0; // 잔여페이지
	int prevPage = (pageNum - pageSize > 0)? pageNum - pageSize : 0 ; // 이전페이지
*/	
	@Override
	public Map<?, ?> carryOut(Map<?, ?> param) {
		Map<String, Object> par = new HashMap<>();
		par.put("endRow", String.valueOf(pageNum * pageSize));
		par.put("beginRow", String.valueOf(pageNum * pageSize - pGap));
		return null;
	}
}
