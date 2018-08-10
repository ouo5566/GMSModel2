package template;

import domain.MemberBean;
import enums.MemberQuery;

public class UpdateQuery extends QueryTemplate{
	@Override
	void initialize() {
		map.put("sql", MemberQuery.UPDATE.toString());
	}
	
	@Override
	void startPlay() {
		try {
			int i = 1;
			pstmt.setString(i++, ((MemberBean) map.get("value")).getMemberId());
			pstmt.setString(i++, ((MemberBean) map.get("value")).getTeamId());
			pstmt.setString(i++, ((MemberBean) map.get("value")).getName());
			pstmt.setString(i++, ((MemberBean) map.get("value")).getSsn());
			
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