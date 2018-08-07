package proxy;

import java.util.Map;

public class PageProxy implements Proxy{

	@Override
	public Map<?, ?> carryOut(Map<?, ?> param) {
		request.setAttribute("nextPage", (nextPage > 0)); 
		request.setAttribute("prevPage", (prevPage > 0));
		request.setAttribute("endPage", (nextPage > blockSize) ? block * blockSize : countPage );
		request.setAttribute("beginPage", block * blockSize - bGap);
		return null;
	}

}
