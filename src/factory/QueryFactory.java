package factory;

import enums.*;

public class QueryFactory {
	public static Query createQuery(MemberQuery e, String table, String column) {
		Query q = null;
		switch (e) {
		case SELECT:
			System.out.println("==creat search query==");
			q = new SearchQuery(table, column);
			break;
		case COUNT:
			q = new CountQuery(table, column);
			break;
		default : break;
		}
		return q;
	}
}
