package factory;

import java.util.Map;

public class CountQuery implements Query {
	private Map<?, ?> map;
	public CountQuery(Map<?, ?> map) {
		this.map = map;
	}
	@Override
	public String getQuery() {
		return " SELECT COUNT(*) AS NMEMBER FROM "+ map.get("table") 
				+((map.get("column").equals(""))?"":" WHERE " + map.get("column") + " LIKE ? ");
	}

}
