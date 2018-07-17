package factory;
import java.sql.Connection;

import enums.Vendor;
import pool.DBConstants;

public class DatabaseFactory {
	public static Database createDatabase(Vendor v, String id, String pw) {
		Database db = null;
		String driver = "", url = "";
		switch(v) {
			case ORACLE:
				driver = DBConstants.ORACLE_DRIVER;
				url = DBConstants.CONNECTION_URL;
				db = new Oracle(driver, url, id, pw);
				break;
			//case MYSQL: db = new MySQL() ; break;
			//case MARIADB: db = new MariaDB() ; break;
		}
		return db;
	}
}
