package factory;

import java.util.Map;

import enums.Domain;
import template.ColumnFinder;

public class LoginQuery implements Query {
	private Map<?, ?> map;
	public LoginQuery(Map<?, ?> map) {
		this.map = map;
	}
	@Override
	public String getQuery() {
		return "  SELECT "
				+ ColumnFinder.find(Domain.MEMBER)
				+ "  FROM MEMBER "
				+ "  WHERE MEMBER_ID LIKE ? "
				+ "  AND MEMBER_PW LIKE ? ";
	}

}
