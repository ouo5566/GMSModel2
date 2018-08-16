package enums;

import template.ColumnFinder;

/*
  static은 상수풀에 계속 존재하고 있어 메모리를 잡아먹어 쿼리가 많아지면 그 만큼 실행될 메모리 공간이 좁아진다. 
  enum을 사용하여 static에 사용할 상수를 객체로 만들어 프로그램이 실행될 때만 존재하도록 한다.
  */

public enum MemberQuery {
	INSERT,
	LIST, SELECT, RETRIEVE, COUNT,
	UPDATE,
	DELETE,
	LOGIN, COUNT_SELECT;
	@Override
	public String toString() {
		String s = "";
		String memberColumn = ColumnFinder.find(Domain.MEMBER);
		switch(this) {
		case INSERT:
			s = " INSERT INTO MEMBER ( " + ColumnFinder.find(Domain.MEMBER) + ") "
				+ " VALUES  ( ?, ?, ?, ?, ?, ?, ?, ?, '' ) ";
			break;
		case LIST:
			s = "SELECT " + memberColumn
				+ " FROM ( SELECT ROWNUM AS \"NUM\", A.* "
						+ "FROM ( SELECT * "
							+ " FROM MEMBER " 
							+ " ORDER BY ROWNUM DESC) A "
					+ " )B "
				+ " WHERE B.NUM BETWEEN ? AND ? ";
			break;
		case SELECT:
			s = "SELECT " + memberColumn
				+ " FROM ( SELECT ROWNUM AS \"NUM\", A.* "
						+ "FROM ( SELECT * "
							+ " FROM MEMBER "
							+ " WHERE %s LIKE ? " 
							+ " ORDER BY ROWNUM DESC) A "
					+ " )B "
				+ " WHERE B.NUM BETWEEN ? AND ? ";
			break;
		case RETRIEVE:
			s = "SELECT " + memberColumn
				+ " FROM  MEMBER "
				+ " WHERE %s LIKE ? ";
			break;
		case COUNT:
			s = "SELECT COUNT(*) AS NMEMBER FROM MEMBER ";
			break;
		case COUNT_SELECT:
			s = " SELECT COUNT(*) AS NMEMBER"
					+ " FROM MEMBER "
					+ " WHERE %s LIKE ? ";
			break;
		case UPDATE:
			s = " UPDATE MEMBER SET "
					+ " PASSWORD = ? , "
					+ " TEAM_ID = ? ,"
					+ " ROLL = ? "
					+ " WHERE MEMBER_ID LIKE ? ";
			break;
		case DELETE:
			s = " DELETE FROM MEMBER "
					+ " WHERE MEMBER_ID LIKE ? ";
			break;
		case LOGIN:
			s = "SELECT " + memberColumn
				+ " FROM  MEMBER "
				+ " WHERE MEMBER_ID LIKE ? "
				+ " AND PASSWORD LIKE ? ";
			break;
		}
		return s;
	}
}