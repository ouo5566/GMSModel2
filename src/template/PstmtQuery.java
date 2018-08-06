package template;

import java.sql.ResultSet;
import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;
import factory.QueryFactory;

public class PstmtQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", 
				QueryFactory.createQuery(
						MemberQuery.valueOf(map.get("query").toString()), 
						map.get("table").toString(), 
						map.get("column").toString()).getQuery());
	}

	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String) map.get("sql"));
			//prepareStatement.setString()...은 void
			if(!map.get("value").toString().equals("")) {
				pstmt.setString(1,
						"%"+map.get("value")+"%");
			}
			// ? 에 값 넣는 작업. 1부터 시작한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			switch (MemberQuery.valueOf(map.get("query").toString())) {
			case COUNT :
				if(rs.next()) {
					map.put("count", rs.getString("NMEMBER"));
				}
				break;
			case SELECT :
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
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}