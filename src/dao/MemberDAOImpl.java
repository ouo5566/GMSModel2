package dao;

import java.util.*;
import domain.*;
import enums.Domain;
import template.*;

public class MemberDAOImpl implements MemberDAO{
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	private QueryTemplate q ;
	
	@Override
	public void insert(MemberBean member) {
		HashMap<String, Object> map = new HashMap<>();
		q = new AddQuery();
		map.put("table", Domain.MEMBER);
		map.put("value", member);
		q.play(map);
	}
	@Override
	public void update(Map<?, ?> param) {
		HashMap<String, Object> map = new HashMap<>();
		q = new UpdateQuery();
		map.put("value", param.get("value"));
		map.put("table", Domain.MEMBER);
		q.play(map);
	}
	@Override
	public void delete(MemberBean member) {
		HashMap<String, Object> map = new HashMap<>();
		q = new DeleteQuery();
		map.put("user", member);
		map.put("table", Domain.MEMBER);
		q.play(map);
	}
	@Override
	public MemberBean login(MemberBean member) {
		q = new RetrieveQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("user", member);
		q.play(map);
		return (MemberBean) q.getMap().get("result");
	}
	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		q = new SearchQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		Iterator<?> keys = param.keySet().iterator();
		while(keys.hasNext()) {
			String key = (String) keys.next();
			map.put(key, param.get(key));
		}
		map.put("table", Domain.MEMBER);
		q.play(map);
		for(Object o : q.getList()) {
			list.add((MemberBean) o);
		}
		return list;
	}
	@Override
	public MemberBean selectOne(String id) {
		System.out.println("==MemberDAOImpl selectOne==");
		q = new RetrieveQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("column", "member_id");
		map.put("value", id);
		map.put("table", Domain.MEMBER);
		q.play(map);
		return (MemberBean) q.getMap().get("result");
	}
	@Override
	public String count(Map<?, ?> param) {
		q = new CountQuery();
		q.play(param);
		return (String) q.getMap().get("result");
	}
	
}
