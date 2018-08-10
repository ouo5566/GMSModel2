package template;

import enums.MemberQuery;

public class DeleteQuery extends QueryTemplate{
	@Override
	void initialize() {
		map.put("sql", MemberQuery.DELETE.toString());
	}
	
	@Override
	void startPlay() {
		try {
			int i = 1;
			pstmt.setString(i++, map.get("value").toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}