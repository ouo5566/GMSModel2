package template;

import java.sql.ResultSet;
import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;
import factory.QueryFactory;

public class PstmtQuery extends QueryTemplate{
	@Override
	void initialize() {
		map.put("sql", QueryFactory.createQuery(map).getQuery());
		System.out.println(map.get("sql"));
	}
	
	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String) map.get("sql"));
			//prepareStatement.setString()...은 void
			if(map.get("query").toString().equals("LOGIN")) {
				pstmt.setString(1, ((MemberBean) map.get("value")).getMemberId());
				pstmt.setString(2, ((MemberBean) map.get("value")).getPassword());
			}
			if(map.get("query").toString().equals("INSERT")) {
				pstmt.setString(1, ((MemberBean) map.get("value")).getMemberId());
				pstmt.setString(2, ((MemberBean) map.get("value")).getTeamId());
				pstmt.setString(3, ((MemberBean) map.get("value")).getName());
				pstmt.setString(4, ((MemberBean) map.get("value")).getSsn());
				pstmt.setString(5, ((MemberBean) map.get("value")).getRoll());
				pstmt.setString(6, ((MemberBean) map.get("value")).getPassword());
				pstmt.setString(7, ((MemberBean) map.get("value")).getAge());
				pstmt.setString(8, ((MemberBean) map.get("value")).getGender());
				pstmt.setString(9, "");
			}
			if(!map.get("value").equals("")) {
				pstmt.setString(1,map.get("value").toString());
			}
			if(!map.get("beginRow").equals("")) {
				pstmt.setString(1, map.get("beginRow").toString());
				pstmt.setString(2, map.get("endRow").toString());
			}
			// ? 에 값 넣는 작업. 1부터 시작한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = null;
			if(map.get("query").toString().equals("INSERT")) {
				pstmt.executeUpdate();
				return;
			}else {
				rs = pstmt.executeQuery();
			}
			switch (MemberQuery.valueOf(map.get("query").toString())) {
			case COUNT :
				if(rs.next()) {
					result = rs.getString("NMEMBER");
				}
				break;
			case LOGIN :
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