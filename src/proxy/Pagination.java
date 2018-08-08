package proxy;

import lombok.Data;
import service.MemberServiceImpl;

@Data
public class Pagination implements Proxy{
	private int pageSize, blockSize, countRow, countPage,
	pageNum, block, endRow, beginRow, beginPage, endPage;
	private boolean nextPage, prevPage;
	@Override
	public void carryOut(Object o) {
		this.pageNum = Integer.parseInt(o.toString());
		this.pageSize = 5 ;
		this.blockSize = 5 ;
		this.countRow = Integer.parseInt(MemberServiceImpl.getInstance().memberCount());
		this.countPage = countRow / pageSize + ((countRow % pageSize == 0) ? 0 : 1 ); // 총 페이지
		this.block = ( pageNum + (blockSize - 1) ) / blockSize ;
		int nextPage = ((countPage - block * blockSize > 0))? countPage - block * blockSize : 0 ,
			prevPage = (countPage - ( nextPage + blockSize ) > 0)? countPage-( nextPage + blockSize ) : 0 ;
		this.nextPage = nextPage > 0 ;
		this.prevPage = prevPage > 0 ;
		this.endRow = pageNum * pageSize;
		this.beginRow = pageNum * pageSize - (pageSize - 1);
		this.endPage = ((countPage - nextPage) % blockSize == 0) ? block * blockSize : countPage ;
		this.beginPage = block * blockSize - (blockSize - 1) ;
	}
	/*
		test.java 에서 실험		
		int pageSize = 5 ;
		int blockSize = 5 ;
		int countPage = countRow / pageSize + ((countRow % pageSize == 0) ? 0 : 1 ); // 총 페이지
		int pageNum = (pagenum == 0)? 1 : pagenum;
		int block = (bl == 0)? 1 : bl ;
		int nextPage = ((countPage - block * blockSize > 0))? countPage - block * blockSize : 0 ;
		int prevPage = ( countPage - ( nextPage + blockSize ) > 0 )? countPage - ( nextPage + blockSize ) : 0 ;
		int endRow = pageNum * pageSize;
		int beginRow = pageNum * pageSize - (pageSize - 1);
		int endPage = ((countPage - nextPage) % blockSize == 0) ? block * blockSize : countPage ;
		int beginPage = block * blockSize - (blockSize - 1) ;
		
	 */
}
