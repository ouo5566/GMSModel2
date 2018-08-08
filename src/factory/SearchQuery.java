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
		String all = ColumnFinder.find(Domain.valueOf(map.get("table").toString()));
		return "SELECT " + all
				+ " FROM ( "
					+ " SELECT ROWNUM AS \"NUM\", " + all
					+ " FROM "+
						" ( SELECT " + all
						+ " FROM " 
						+ map.get("table") 
						+ ( (map.get("column") == null )?
								"" : " WHERE " + map.get("column") + " LIKE ? " )
						+ " ORDER BY ROWNUM DESC) A "
					+ " )B "
				+ " WHERE B.NUM BETWEEN "+ map.get("beginRow") +" AND " + map.get("endRow");
	}
	
}
