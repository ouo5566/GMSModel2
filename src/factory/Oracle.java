package factory;

import java.sql.Connection;
import java.sql.DriverManager;

import pool.DBConstants;

public class Oracle implements Database{
	private Connection conn;
	private String driver, url, id, pw;
	public Oracle(String driver, String url, String id, String pw) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pw = pw;
	}
	@Override
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
