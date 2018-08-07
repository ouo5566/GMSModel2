package command;

import java.lang.reflect.Field;
import domain.MemberBean;
import service.MemberServiceImpl;

public class Test {
	public static void main(String[] args) {
		int pagenum = 12 , bl = 0 ;
		int countRow = 163;
		
		System.out.println("CountRow : "+countRow);
		int pageSize = 5 ;
		System.out.println("PageSize : "+pageSize);
		int blockSize = 5 ;
		System.out.println("BlockSize : "+blockSize);
		int countPage = countRow / pageSize + ((countRow % pageSize == 0) ? 0 : 1 ); // 총 페이지
		System.out.println("CountPage : "+ countRow + " / " + pageSize + " + " 
				+ "((" + countRow + " % " + pageSize + " == 0) ? 0 : 1 ) = "+countPage+" (이상없음) ");
		int pageNum = (pagenum == 0)? 1 : pagenum;
		System.out.println("PageNum : ( " + pagenum + " == 0 )? 1 : " + pagenum + " = "+pageNum+" (이상없음) ");
		
		//System.out.println("Block : ( " +bl+ " == 0 )? ( "+pageNum+" + ( " + pageSize +" - 1) ) / "+pageSize+" : "+bl+" = "+block+" (이상함) ");
		int block = ( pagenum + (blockSize - 1) ) / blockSize ; // 이 식으로 적용.
		//int block = (bl == 0)? 1 : bl ;
		System.out.println("Block : ( "+pagenum+" + ( "+blockSize+" - 1) ) / "+blockSize+"  = "+block);
		System.out.println("Block : ( " +bl+ " == 0 )? 1 : "+bl+" = "+block+" (이상없음) ");
		int nextPage = ((countPage - block * blockSize > 0))? countPage - block * blockSize : 0 ;
		
		System.out.println("NextPage : (( "+countPage+" - "+block+" * "+blockSize+" > 0 ))? "+
				countPage+" - "+block+" * "+blockSize+" : 0 = "+nextPage+" (이상없음) ");
		//int prevPage = (pageNum - blockSize > 0)? pageNum - blockSize : 0 ;
		//System.out.println("PrevPage : ( "+pageNum+" - "+blockSize+" > 0)? "+pageNum+" - "+blockSize+" : 0 = "+prevPage);
		int prevPage = ( countPage - ( nextPage + blockSize ) > 0 )? countPage - ( nextPage + blockSize ) : 0 ;
		System.out.println("PrevPage : ( "+countPage+" - ( "+nextPage+" + "+blockSize+" ) > 0 )? "
				+countPage+" - ( "+nextPage+" + "+blockSize+" ) : 0 = "+prevPage+" (이상없음) ");
		int endRow = pageNum * pageSize;
		System.out.println("EndRow : "+endRow);
		int beginRow = pageNum * pageSize - (pageSize - 1);
		System.out.println("BeginRow : "+beginRow);
		int endPage = ((countPage - nextPage) % blockSize == 0) ? block * blockSize : countPage ;
		System.out.println("EndPage : "+endPage);
		int beginPage = block * blockSize - (blockSize - 1) ;
		System.out.println("BeginPage : "+beginPage);
		
		
		
		
		
		
		
		
		/*String s = "", temp = "", upper = "";
		Class<MemberBean> clazz = MemberBean.class;
		Field[] f = clazz.getDeclaredFields();
		for(int i = 0; i < f.length ; i++) {
			upper = "";
			char[] arr = f[i].getName().toCharArray();
			for(int j = 0 ; j < arr.length ; j++ ) {
				if(String.valueOf(arr[j]).equals(String.valueOf(arr[j]).toUpperCase())) {
					upper = f[i].getName().replaceAll(String.valueOf(arr[j]), "_"+String.valueOf(arr[j]));
				}
			}
			temp = (upper.equals(""))? f[i].getName() : upper;
			s += (i!=(f.length-1))? temp + " , " : temp;
		}
		System.out.println(s);
		
		String a = "memberId";
		char[] arr = a.toCharArray();
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
			if(String.valueOf(arr[i]).equals(String.valueOf(arr[i]).toUpperCase())) {
				System.out.println(" 대문자!! ");
				String c = a.replaceAll(String.valueOf(arr[i]), "_"+String.valueOf(arr[i]));
				System.out.println(c.toUpperCase());
			}
		}*/
	}
}
