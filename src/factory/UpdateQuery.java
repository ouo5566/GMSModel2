package factory;

import java.util.Map;

public class UpdateQuery implements Query {
	private Map<?, ?> map;
	public UpdateQuery(Map<?, ?> map) {
		this.map = map;
	}
	@Override
	public String getQuery() {
		return " UPDATE "
				+ map.get("table") + " SET "
				+ " MEMBER_PW = '%s', "
				+ " TEAM_ID = '%s' ,"
				+ " ROLL = '%s' "
				+ " WHERE MEMBER_ID LIKE '%s' ";
	}

}