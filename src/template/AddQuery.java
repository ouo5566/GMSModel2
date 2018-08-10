package template;

import domain.MemberBean;
import enums.MemberQuery;

public class AddQuery extends QueryTemplate{
	@Override
	void initialize() {
		map.put("sql", MemberQuery.INSERT.toString());
	}
	
	@Override
	void startPlay() {
		try {
			int i = 1;
			pstmt.setString(i++, ((MemberBean) map.get("value")).getMemberId());
			pstmt.setString(i++, ((MemberBean) map.get("value")).getTeamId());
			pstmt.setString(i++, ((MemberBean) map.get("value")).getName());
			pstmt.setString(i++, ((MemberBean) map.get("value")).getSsn());
			pstmt.setString(i++, ((MemberBean) map.get("value")).getRoll());
			pstmt.setString(i++, ((MemberBean) map.get("value")).getPassword());
			pstmt.setString(i++, ((MemberBean) map.get("value")).getAge());
			pstmt.setString(i++, ((MemberBean) map.get("value")).getGender());
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