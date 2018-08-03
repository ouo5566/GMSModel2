package factory;

import java.util.Map;

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
	
	public static Database createDatabase2(Map<String, Object> map) {
		Database db = null;
		String driver = "", url = "";
		switch((Vendor)map.get("vendor")) {
			case ORACLE:
				driver = DBConstants.ORACLE_DRIVER;
				url = DBConstants.CONNECTION_URL;
				db = new Oracle(driver, url,
						(String)map.get("username"),
						(String)map.get("password"));
				break;
		default: break;
		}
		return db;
	}
}
