package dao;

import java.util.*;
import domain.*;
import enums.*;
import template.*;

public class MemberDAOImpl implements MemberDAO{
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	@Override
	public void insert(MemberBean member) {
		QueryTemplate q = new PstmtQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("query", MemberQuery.INSERT);
		map.put("value", member);
		q.play(map);
	}
	@Override
	public void update(Map<?, ?> param) {
		QueryTemplate q = new PstmtQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("query", MemberQuery.UPDATE);
		map.put("value", param.get("value"));
		q.play(map);
	}
	@Override
	public void delete(MemberBean member) {
		
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
	public List<MemberBean> selectSome(Map<?, ?> param) {
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		map.put("column", param.get("column"));
		map.put("value", param.get("word"));
		map.put("beginRow", param.get("beginRow"));
		map.put("endRow", param.get("endRow"));
		map.put("table", Domain.MEMBER);
		map.put("query", MemberQuery.SELECT);
		q.play(map);
		for(Object o : q.getList()) {
			list.add((MemberBean) o);
		}
		return list;
	}
	@Override
	public MemberBean selectOne(String id) {
		QueryTemplate q = new PstmtQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("query", MemberQuery.RETRIEVE);
		map.put("table", Domain.MEMBER);
		map.put("column", Columns.MEMBER_ID);
		map.put("value", id);
		q.play(map);
		System.out.println(q.getList());
		return (MemberBean) q.getList().get(0);
	}
	@Override
	public String count() {
		QueryTemplate q = new PstmtQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("query", MemberQuery.COUNT);
		q.play(map);
		return (String) q.getList().get(0);
	}
	
}
