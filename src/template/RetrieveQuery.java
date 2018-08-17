package template;

import java.sql.ResultSet;

import domain.ImageBean;
import domain.MemberBean;
import enums.Domain;
import enums.ImageQuery;
import enums.MemberQuery;

public class RetrieveQuery extends QueryTemplate{
	@Override
	void initialize() {
		String sql = "";
		switch (Domain.valueOf(map.get("table").toString())) {
		case MEMBER:
			sql = (map.get("column") == null) ?
						MemberQuery.LOGIN.toString()
							: String.format(MemberQuery.RETRIEVE.toString(), map.get("column"));
			break;
		case IMAGE:
			sql = ImageQuery.SEARCH.toString();
			break;
		default:
			break;
		}
		map.put("sql", sql);
	}
	
	@Override
	void startPlay() {
		System.out.println(map.get("sql"));
		try {
			int i = 1;
			if(map.get("sql").toString().equals(MemberQuery.LOGIN.toString())) { 
				pstmt.setString(i++, ((MemberBean) map.get("user")).getMemberId());
				pstmt.setString(i++, ((MemberBean) map.get("user")).getPassword());
				System.out.println("==login setString==");
			}else {
				pstmt.setString(i++,  map.get("value").toString());
				System.out.println("==value setString==");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			Object o = null;
			while(rs.next()) {
				switch (Domain.valueOf(map.get("table").toString())) {
				case MEMBER:
					MemberBean mem = new MemberBean();
					mem.setMemberId(rs.getString("MEMBER_ID"));
					mem.setTeamId(rs.getString("TEAM_ID"));
					mem.setName(rs.getString("NAME"));
					mem.setSsn(rs.getString("SSN"));
					mem.setRoll(rs.getString("ROLL"));
					mem.setPassword(rs.getString("PASSWORD"));
					mem.setGender(rs.getString("GENDER"));
					mem.setAge(rs.getString("AGE"));
					o = mem;
					break;
				case IMAGE:
					ImageBean img = new ImageBean();
					img.setImgName(rs.getString("IMG_NAME"));
					img.setExtension(rs.getString("EXTENSION"));
					o = img;
					break;
				default:
					break;
				}
			}
			map.put("result", o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}