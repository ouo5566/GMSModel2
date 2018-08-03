package template;

import java.lang.reflect.Field;
import domain.MemberBean;
import enums.Columns;
import enums.Domain;

public class ColumnFinder {
	public static String find(Domain domain) {
		String s = "";
		//Class<MemberBean> clazz = null;
		Class c = null;
		switch (domain) {
		case MEMBER:
			//clazz = MemberBean.class;
			c = Columns.class;
			break;
		default:
			break;
		}
		//Field[] f = clazz.getDeclaredFields();
		Field[] ff = c.getDeclaredFields();
		/*for(int i = 0; i<f.length-1;i++) {
			s+=(i!=(f.length-1))?
					f[i].getName()+","
						: f[i].getName();
		}*/
		for(int i = 0; i<ff.length-1;i++) {
			s+=(i!=(ff.length-1))?
					ff[i].getName()+","
					: ff[i].getName();
		}
		return s;
	}
}
