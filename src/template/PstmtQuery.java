package template;

import java.sql.ResultSet;
import domain.MemberBean;
import enums.Domain;
import factory.DatabaseFactory;

public class PstmtQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", String.format(
				" SELECT "
				+ ColumnFinder.find(Domain.MEMBER).toUpperCase()
				+ " FROM %s "
				+ " WHERE "
				+ "	%s "
				+ ( (map.get("value") != null)? " LIKE ? ":" BETWEEN ? AND ? " ),
					map.get("table"),
					map.get("column")));
	}

	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String) map.get("sql"));
			//prepareStatement.setString()...은 void
			if(map.get("value") != null) {
				pstmt.setString(1, map.get("value").toString());
			}else {
				pstmt.setString(1, map.get("beginRow").toString());
				// ? 에 값 넣는 작업. 1부터 시작한다.
				pstmt.setString(2, map.get("endRow").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			MemberBean mem = null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setMemberId(rs.getString("MEMBER_ID"));
				mem.setTeamId(rs.getString("TEAM_ID"));
				mem.setName(rs.getString("NAME"));
				mem.setSsn(rs.getString("SSN"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setGender(rs.getString("GENDER"));
				mem.setAge(rs.getString("AGE"));
				list.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
