package command;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;


import domain.MemberBean;
import enums.Domain;
import enums.Vendor;
import factory.DatabaseFactory;
import pool.DBConstants;
import template.ColumnFinder;

public class Test {
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		map.put("vendor", Vendor.ORACLE);
		map.put("username", DBConstants.USERNAME);
		map.put("password", DBConstants.PASSWORD);
		PreparedStatement pstmt;
		try {
			pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement(
					" INSERT INTO MEMBER ( " + ColumnFinder.find(Domain.MEMBER) + ") "
					+ " VALUES  ( ?, ?, ?, ?, ?, ?, ?, ?, ? ) ");
			int i = 1;
			pstmt.setString(i++,String.valueOf(i));
			pstmt.setString(i++,String.valueOf(i));
			pstmt.setString(i++,String.valueOf(i));
			pstmt.setString(i++,String.valueOf(i));
			pstmt.setString(i++,String.valueOf(i));
			pstmt.setString(i++,String.valueOf(i));
			pstmt.setString(i++,String.valueOf(i));
			pstmt.setString(i++,String.valueOf(i));
			pstmt.setString(i++,String.valueOf(i));
			System.out.println("i : "+i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
