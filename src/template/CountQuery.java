package template;

import java.sql.ResultSet;

import enums.MemberQuery;

public class CountQuery extends QueryTemplate{
	@Override
	void initialize() {
		map.put("sql", (map.get("column").equals("")) ? 
							MemberQuery.COUNT.toString()
								: String.format(
										MemberQuery.COUNT_SELECT.toString()
										, map.get("column")) );
	}
	
	@Override
	void startPlay() {
		try {
			int i = 1;
			if(!map.get("column").equals("")) { 
				pstmt.setString(i++, map.get("value").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				map.put("result", rs.getString("NMEMBER"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}