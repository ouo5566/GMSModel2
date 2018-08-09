package factory;
import java.util.Map;

import enums.Domain;
import template.ColumnFinder;

public class RetrieveQuery implements Query{
	private Map<?, ?> map;
	public RetrieveQuery(Map<?, ?> map) {
		this.map = map;
	}
	@Override
	public String getQuery() {
		return "SELECT "
					+ ColumnFinder.find(Domain.valueOf(map.get("table").toString()))
				+ " FROM "
					+ map.get("table") 
				+ " WHERE " 
					+ map.get("column") + " LIKE ? " ;
	}
}
