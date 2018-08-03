package factory;

public class CountQuery implements Query {
	private String table, column;
	public CountQuery(String table, String column) {
		this.table = table;
		this.column = column;
	}
	@Override
	public String getQuery() {
		return " SELECT COUNT(*) AS NMEMBER FROM "+ table 
				+((column.equals(""))?"":" WHERE " + column + " LIKE ? ");
	}

}
