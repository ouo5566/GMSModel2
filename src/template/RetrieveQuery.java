package template;

import java.sql.ResultSet;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class RetrieveQuery extends QueryTemplate{
	@Override
	void initialize() {
		map.put("sql", (map.get("column").equals("")) ?
				MemberQuery.LOGIN.toString() :
					String.format(MemberQuery.RETRIEVE.toString(), map.get("column")));
	}
	
	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String) map.get("sql"));
			int i = 1;
			if(map.get("column").equals("")) { 
				pstmt.setString(i++, ((MemberBean) map.get("user")).getMemberId());
				pstmt.setString(i++, ((MemberBean) map.get("user")).getPassword());
			}else{
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
				}
				map.put("result", mem);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}