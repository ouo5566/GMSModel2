package factory;
import enums.Domain;
import template.ColumnFinder;

public class SearchQuery implements Query{
	private String table, column;
	public SearchQuery(String table, String column) {
		this.table = table;
		this.column = column;
	}
	@Override
	public String getQuery() {
		System.out.println("column : "+column);
		return "  SELECT "
				+ ColumnFinder.find(Domain.valueOf(table)).toUpperCase()
				+ " FROM " + table
				+ ((column.equals("")) ? "" : " WHERE "+ column + " LIKE ? ");
	}
	
}
