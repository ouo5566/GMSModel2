package template;

import java.sql.ResultSet;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class RetrieveQuery extends QueryTemplate{
	@Override
	void initialize() {
		System.out.println(map.get("column") == null);
		map.put("sql", ( map.get("column") == null ) ?
				MemberQuery.LOGIN.toString() :
					String.format(MemberQuery.RETRIEVE.toString(), map.get("column")));
	}
	
	@Override
	void startPlay() {
		System.out.println(map.get("sql"));
		try {
			int i = 1;
			if(map.get("column") == null) { 
				pstmt.setString(i++, ((MemberBean) map.get("user")).getMemberId());
				pstmt.setString(i++, ((MemberBean) map.get("user")).getPassword());
				System.out.println("==login setString==");
			}else{
				System.out.println(i + "." + map.get("value".toString()));
				pstmt.setString(i++, map.get("value").toString());
				System.out.println("==value setString==");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			System.out.println("endPlay start");
			ResultSet rs = pstmt.executeQuery();
			MemberBean mem = new MemberBean();
			while(rs.next()) {
				System.out.println("while start");
				mem.setMemberId(rs.getString("MEMBER_ID"));
				mem.setTeamId(rs.getString("TEAM_ID"));
				mem.setName(rs.getString("NAME"));
				mem.setSsn(rs.getString("SSN"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setGender(rs.getString("GENDER"));
				mem.setAge(rs.getString("AGE"));
				System.out.println("while end");
				System.out.println(rs.getString("MEMBER_ID"));
			}
			System.out.println("==result mem==\n"+mem);
			map.put("result", mem);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}