package enums;

import template.ColumnFinder;

public enum ImageQuery {
	INSERT, SEARCH;
	@Override
	public String toString() {
		String s = "";
		switch (this) {
		case INSERT:
			s = " INSERT INTO IMAGE ("+ColumnFinder.find(Domain.IMAGE)+") "
					+ " VALUES ( IMG_SEQ.NEXTVAL , ?, ?, ? ) ";
			break;
		case SEARCH:
			s = " SELECT IMG_NAME, EXTENSION "
					+ " FROM IMAGE "
					+ " WHERE MEMBER_ID LIKE ? ";
			break;
		}
		return s;
	}
}
