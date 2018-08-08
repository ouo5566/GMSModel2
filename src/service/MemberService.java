package service;

import java.util.List;
import java.util.Map;
import domain.*;

public interface MemberService {
	public void create(MemberBean member);
	public void modify(Map<?, ?> param);
	public void remove(MemberBean member);
	public List<MemberBean> search(Map<?, ?> param); // ? 와일드카드 : 무언가 하나, One, 무슨 타입이든 들어간다 / * 아스타 : All
	public MemberBean retrieve(String id);
	public String count();
	public boolean loginFlag(MemberBean member);
	public MemberBean login(MemberBean member);
	
/*	
	public boolean findByUser(MemberBean member);
 	public List<MemberBean> findByTeamId(String team);
	public List<MemberBean> list();
	public List<MemberBean> list(String page);
	public List<MemberBean> findByWord(Columns column, String word);
	public List<MemberBean> findByName(String name);
*/
}
