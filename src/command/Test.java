package command;

import java.lang.reflect.Field;
import domain.MemberBean;

public class Test {
	public static void main(String[] args) {
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
		
		/*String a = "memberId";
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
