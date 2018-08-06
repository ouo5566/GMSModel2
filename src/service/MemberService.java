package service;
import java.util.List;
import java.util.Map;

import domain.*;
import enums.Columns;

public interface MemberService {
	public void createMember(MemberBean member);
	public void modifyMember(MemberBean member);
	public void removeMember(MemberBean member);
	public boolean loginFlag(MemberBean member);
	public boolean findByUser(MemberBean member);
	public List<MemberBean> list();
	public List<MemberBean> list(String page);
	public List<MemberBean> list(Map<?, ?> param); // ? 와일드카드 : 무언가 하나, One, 무슨 타입이든 들어간다 / * 아스타 : All
	public List<MemberBean> findByWord(Columns column, String word);
	public MemberBean findById(String id);
	public String memberCount();
	public MemberBean login(MemberBean member);
/*	public List<MemberBean> findByTeamId(String team);
	public List<MemberBean> findByName(String name);*/
}
