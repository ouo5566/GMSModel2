package dao;

import java.util.*;
import domain.*;
import enums.*;
import factory.*;
import pool.DBConstants;
import template.*;

public class MemberDAOImpl implements MemberDAO{
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	
	@Override
	public void insertMember(MemberBean member) {
		QueryTemplate q = new PstmtQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("query", MemberQuery.INSERT);
		map.put("value", member);
		q.play(map);
	}
	
	@Override
	public String selectMemberCount() {
		QueryTemplate q = new PstmtQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("query", MemberQuery.COUNT);
		q.play(map);
		return q.getResult();
	}
	@Override
	public void updateMember(MemberBean member) {
		QueryTemplate q = new PstmtQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("query", MemberQuery.UPDATE);
		map.put("value", member);
		q.play(map);
		/*try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstants.USERNAME, DBConstants.PASSWORD)
			.getConnection().createStatement().executeUpdate(String.format(MemberQuery.UPDATE_MEMBER.toString(),
					member.getPassword(), member.getTeamId(), member.getRoll(), member.getMemberId()));
		} catch (Exception e) {e.printStackTrace();}*/
	}
	
	@Override
	public void deleteMember(MemberBean member) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstants.USERNAME, DBConstants.PASSWORD)
			.getConnection().createStatement().executeUpdate(String.format(MemberQuery.DELETE_MEMBER.toString(),
					member.getMemberId(), member.getPassword()));
		} catch (Exception e) {e.printStackTrace();}
	}
	
	@Override
	public MemberBean login(MemberBean member) {
		QueryTemplate q = new PstmtQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("query", MemberQuery.LOGIN);
		map.put("value", member);
		q.play(map);
		return (MemberBean) q.getList().get(0);
	}

	@Override
	public List<MemberBean> selectMemberAll() {
		QueryTemplate q = new PstmtQuery();
		HashMap<String, Object> map = new HashMap<>();
		List<MemberBean> list = new ArrayList<>();
		map.put("table", Domain.MEMBER);
		map.put("query", MemberQuery.SELECT);
		q.play(map);
		for(Object o : q.getList()) {
			list.add((MemberBean) o);
		}
		return list;
	}
	@Override
	public List<MemberBean> selectMemberAll(Map<?, ?> param) {
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		map.put("query", MemberQuery.SELECT);
		map.put("column", "B.NUM");
		map.put("table", Domain.MEMBER);
		map.put("from", " ( SELECT "
				+ " ROWNUM AS \"NUM\", "
				+ ColumnFinder.find(Domain.MEMBER).toUpperCase()
				+ " FROM (SELECT ROWNUM RO, M.* FROM MEMBER M ORDER BY ROWNUM DESC )A "
				+ " ) B " );
		map.put("beginRow", param.get("beginRow"));
		map.put("endRow", param.get("endRow"));
		q.play(map);
		for(Object o : q.getList()) {
			list.add((MemberBean) o);
		}
		return list;
	}	
	@Override
	public MemberBean selectById(String id) {
		QueryTemplate q = new PstmtQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("query", MemberQuery.SELECT);
		map.put("table", Domain.MEMBER);
		map.put("column", Columns.MEMBER_ID);
		map.put("value", id);
		q.play(map);
		return (MemberBean) q.getList().get(0);
	}
	
	@Override
	public List<MemberBean> selectSome(Columns column, String word) {
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		map.put("column", column);
		map.put("value", word);
		map.put("table", Domain.MEMBER);
		map.put("query", MemberQuery.SELECT);
		q.play(map);
		for(Object o : q.getList()) {
			list.add((MemberBean) o);
		}
		return list;
	}
	@Override
	public List<MemberBean> selectMemberAll(String page) {
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		map.put("column", "B.PAGE");
		map.put("value", page);
		map.put("table", " ( SELECT "
				+ " ROWNUM AS \"NUM\", "
				+ ColumnFinder.find(Domain.MEMBER)
				+ " , ROUND(((ROWNUM+2)/5),0) AS \"PAGE\" "
				+ " FROM (SELECT ROWNUM RO, M.* FROM MEMBER M ORDER BY ROWNUM DESC )A "
				+ " ) B " );
		q.play(map);
		for(Object o : q.getList()) {
			list.add((MemberBean) o);
		}
		return list;
	}
	
	/*
	@Override
	public List<MemberBean> selectSome(Columns column, String word) {
		/*try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstants.USERNAME, DBConstants.PASSWORD)
					.getConnection().createStatement().executeQuery(
							QueryFactory.createQuery(
									MemberQuery.SELECT, 
									Domain.MEMBER, 
									column.toString(), word).getQuery());
			MemberBean mem = null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setMemberId(rs.getString("MEMID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PW"));
				mem.setSsn(rs.getString("SSN"));
				mem.setGender(rs.getString("GENDER"));
				mem.setAge(rs.getString("AGE"));
				list.add(mem);
			}
		} catch (Exception e) {e.printStackTrace();}
		return list;
	}
	@Override
	public List<MemberBean> selectByTeamId(String team) {
		List<MemberBean> list = new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstants.USERNAME, DBConstants.PASSWORD)
					.getConnection().createStatement().executeQuery(
							QueryFactory.createQuery(
									MemberQuery.SELECT, 
									Domain.MEMBER, 
									Columns.TEAM_ID.toString(), team).getQuery());
			MemberBean mem = null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setMemberId(rs.getString("MEMID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PW"));
				mem.setSsn(rs.getString("SSN"));
				mem.setGender(rs.getString("GENDER"));
				mem.setAge(rs.getString("AGE"));
				list.add(mem);
			}
		} catch (Exception e) {e.printStackTrace();}
		return list;
	}
	
	@Override
	public List<MemberBean> selectByName(String name) {
		List<MemberBean> list = new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstants.USERNAME, DBConstants.PASSWORD)
					.getConnection().createStatement().executeQuery(
							QueryFactory.createQuery(
									MemberQuery.SELECT, 
									Domain.MEMBER, 
									Columns.NAME.toString(),
									"%"+name+"%").getQuery());
			MemberBean mem = null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setMemberId(rs.getString("MEMID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PW"));
				mem.setSsn(rs.getString("SSN"));
				mem.setGender(rs.getString("GENDER"));
				mem.setAge(rs.getString("AGE"));
				list.add(mem);
			}
		} catch (Exception e) {e.printStackTrace();}
		return list;
	}
	@Override
	public MemberBean selectById(MemberBean member) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
}
