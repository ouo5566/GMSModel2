package template;

import java.sql.ResultSet;

import domain.MemberBean;
import enums.MemberQuery;

public class SearchQuery extends QueryTemplate{
	@Override
	void initialize() {
		map.put("sql",
				(map.get("column").equals("")) ?
					MemberQuery.LIST.toString() :
						String.format(MemberQuery.SELECT.toString(), map.get("column"))
			);
	}
	
	@Override
	void startPlay() {
		try {
			System.out.println(map.get("sql"));
			int i = 1;
			if(!map.get("column").equals("")) { 
				pstmt.setString(i++,map.get("value").toString());
			}
			pstmt.setString(i++, map.get("beginRow").toString());
			pstmt.setString(i++, map.get("endRow").toString());
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