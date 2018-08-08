package factory;

import java.util.Map;
import enums.*;

public class QueryFactory {
	public static Query createQuery(Map<?, ?> map) {
		Query q = null;
		switch (MemberQuery.valueOf(map.get("query").toString())) {
		case SELECT:
			q = new SearchQuery(map);
			break;
		case COUNT:
			q = new CountQuery(map);
			break;
		case INSERT :
			q = new InsertQuery(map);
			break;
		case LOGIN :
			q = new LoginQuery(map);
			break;
		case UPDATE :
			q = new UpdateQuery(map);
			break;
		case DELETE :
			q = new DeleteQuery(map);
			break;
		default : break;
		}
		return q;
	}
}