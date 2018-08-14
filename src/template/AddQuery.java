package template;

import domain.*;
import enums.*;

public class AddQuery extends QueryTemplate{
	@Override
	void initialize() {
		String sql = "";
		switch (Domain.valueOf(map.get("table").toString())) {
		case MEMBER:
			sql = MemberQuery.INSERT.toString();
			break;
		case IMAGE:
			sql = ImageQuery.INSERT.toString();
			break;
		default:
			break;
		}
		map.put("sql", sql);
	}	
	@Override
	void startPlay() {
		try {
			System.out.println(map.get("sql"));
			int i = 1;
			switch (Domain.valueOf(map.get("table").toString())) {
			case MEMBER:
				System.out.println("member set String");
				System.out.println((MemberBean) map.get("value"));
				pstmt.setString(i++, ((MemberBean) map.get("value")).getMemberId());
				pstmt.setString(i++, ((MemberBean) map.get("value")).getTeamId());
				pstmt.setString(i++, ((MemberBean) map.get("value")).getName());
				pstmt.setString(i++, ((MemberBean) map.get("value")).getSsn());
				pstmt.setString(i++, ((MemberBean) map.get("value")).getRoll());
				pstmt.setString(i++, ((MemberBean) map.get("value")).getPassword());
				pstmt.setString(i++, ((MemberBean) map.get("value")).getAge());
				pstmt.setString(i++, ((MemberBean) map.get("value")).getGender());
				break;
			case IMAGE:
				pstmt.setString(i++, ((ImageBean) map.get("value")).getImgName());
				pstmt.setString(i++, ((ImageBean) map.get("value")).getExtension());
				pstmt.setString(i++, ((ImageBean) map.get("value")).getMemberId());
				break;
			default:
				break;
			}
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