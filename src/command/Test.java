package command;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import template.ColumnFinder;

public class Test {
	public static void main(String[] args) {
		MemberBean mem = new MemberBean();
		
		Map<String, Object> map = new HashMap<>();
		map.put("query", MemberQuery.SELECT);
		map.put("column", "B.NUM");
		map.put("table", Domain.MEMBER);
		map.put("from", " ( SELECT "
				+ " ROWNUM AS \"NUM\", "
				+ ColumnFinder.find(Domain.MEMBER).toUpperCase()
				+ " FROM (SELECT ROWNUM RO, M.* FROM MEMBER M ORDER BY ROWNUM DESC )A "
				+ " ) B " );
		map.put("beginRow", 1);
		map.put("endRow", 23);
		map.put("test", mem);
		System.out.println((map.size()));
		if(map.get("test") instanceof MemberBean) {
			System.out.println("멤버정보으어으어");
		}
		
		Map<String, Object> test = new HashMap<>();
		test.put("query", "");
		test.put("column", "");
		test.put("test", "");
		test.putAll(map);
		System.out.println(test.size());
		System.out.println(test.get("table"));
		
		/*
		String s = "", temp = "", upper = "";
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
		}
		*/
	}
}
