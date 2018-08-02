package factory;
import enums.Domain;

public class SearchQuery implements Query{
	private Domain table;
	private String column, word;
	public SearchQuery(Domain table, String column, String word) {
		this.table = table;
		this.column = column;
		this.word = word;
	}
	@Override
	public String getQuery() {
		String sql = "  SELECT "
				+ " MEMBER_ID MEMID, "
				+ " TEAM_ID TEAMID, "
				+ " NAME, "
				+ " ROLL, "
				+ " MEMBER_PW PW, "
				+ " SSN ,"
				+ " GENDER, "
				+ " AGE " 
				+ " FROM " + table;
		return (column.equals(""))?sql:sql + " WHERE "+ column + " LIKE '" + word+"'";
	}
	
}
