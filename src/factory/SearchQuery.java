package factory;
import java.util.Map;

import enums.Domain;
import template.ColumnFinder;

public class SearchQuery implements Query{
	private Map<?, ?> map;
	public SearchQuery(Map<?, ?> map) {
		this.map = map;
	}
	@Override
	public String getQuery() {
		return "  SELECT "
				+ ColumnFinder.find(Domain.valueOf(map.get("table").toString())).toUpperCase()
				+ " FROM " + ((map.get("from").equals("")) ? map.get("table") : map.get("from"))
				+ ((map.get("column").equals("")) ? "" : " WHERE "+ map.get("column") 
				+ ((map.get("beginRow").equals(""))? " LIKE ? " : " BETWEEN ? AND ? "));
	}
	
}
