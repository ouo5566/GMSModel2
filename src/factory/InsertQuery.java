package factory;

import java.util.Map;

import enums.Domain;
import template.ColumnFinder;

public class InsertQuery implements Query{
	private Map<?, ?> map;
	public InsertQuery(Map<?, ?> map) {
		this.map = map;
	}
	@Override
	public String getQuery() {
		String wild = "";
		for( int i = 0 ; i < Integer.parseInt(ColumnFinder.columnCount(Domain.valueOf(map.get("table").toString()))) ; i++ ) {
			wild += ( i == Integer.parseInt(ColumnFinder.columnCount(Domain.valueOf(map.get("table").toString())) ) - 1 )?
					" ? " : " ? ,";
		}
		return " INSERT INTO " + map.get("table")
				+ " (" + ColumnFinder.find(Domain.valueOf(map.get("table").toString())) + ") "
				+ " VALUES  ( " + wild + " ) ";
	}

}