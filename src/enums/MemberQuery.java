package enums;
/*
  static은 상수풀에 계속 존재하고 있어 메모리를 잡아먹어 쿼리가 많아지면 그 만큼 실행될 메모리 공간이 좁아진다. 
  enum을 사용하여 static에 사용할 상수를 객체로 만들어 프로그램이 실행될 때만 존재하도록 한다.
  */
public enum MemberQuery {
	LOGIN, SELECT_OVERLAP_USER, UPDATE_MEMBER, DELETE_MEMBER, SELECT, COUNT, INSERT, UPDATE, DELETE;
	@Override
	public String toString() {
		String sql = "";
		switch(this) {
			case LOGIN :
				sql = "  SELECT MEMBER_ID USERID, " +
					    "  TEAM_ID TEAMID, " +
					    "  ROLL, " +
					    "  PASSWORD PW, " +
					    "  NAME, " +
					    "  SSN, " +
					    "  GENDER, " +
					    "  AGE " +
						"  FROM MEMBER " +
						"  WHERE MEMBER_ID LIKE '%s' " +
					    "  AND MEMBER_PW LIKE '%s'";
				break;
			case SELECT_OVERLAP_USER :
				sql = "  SELECT MEMBER_ID USERID " +
						"  FROM MEMBER " +
						"  WHERE NAME LIKE '%s' " +
					    "  AND SSN LIKE '%s'";
				break;
			case UPDATE_MEMBER :
				sql = " UPDATE MEMBER SET "
						+ " MEMBER_PW = '%s', "
						+ " TEAM_ID = '%s' ,"
						+ " ROLL = '%s' "
						+ " WHERE MEMBER_ID LIKE '%s' ";
				break;
			case DELETE_MEMBER:
				sql = " DELETE FROM MEMBER "
						+ " WHERE MEMBER_ID LIKE '%s' "
						+ " AND MEMBER_PW LIKE '%s' ";
				break;
			default: sql = super.toString() ; break;
		}
		return sql;
	}
}