package factory;

import enums.Domain;

public class CountQuery implements Query {
	private Domain table;
	private String column, word;
	public CountQuery(Domain table, String column, String word) {
		this.table = table;
		this.column = column;
		this.word = word;
	}
	@Override
	public String getQuery() {
		return " SELECT COUNT(*) AS NMEMBER FROM "+ table 
				+((column.equals(""))?"":" WHERE " + column + " LIKE '" + word + "' ");
	}

}
