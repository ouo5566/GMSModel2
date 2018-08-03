package template;

import java.lang.reflect.Field;
import domain.MemberBean;
import enums.Domain;

public class ColumnFinder {
	public static String find(Domain domain) {
		String s = "", upper = "", temp = "";
		Class<MemberBean> clazz = null;
		switch (domain) {
		case MEMBER:
			clazz = MemberBean.class;
			break;
		default:
			break;
		}
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
		return s;
	}
}
