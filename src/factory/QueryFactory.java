package factory;

import enums.*;

public class QueryFactory {
	public static Query createQuery(MemberQuery e, Domain table, String column,  String word) {
		Query q = null;
		switch (e) {
		case SELECT:
			q = new SearchQuery(table, column, word);
			break;
		default : break;
		}
		return q;
	}
}
