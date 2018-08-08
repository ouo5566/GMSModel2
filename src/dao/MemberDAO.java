package dao;
import java.util.List;
import java.util.Map;
import domain.*;

public interface MemberDAO {
	public void insert(MemberBean member);
	public void update(Map<?, ?> param);
	public void delete(MemberBean member);
	public MemberBean login(MemberBean member);
	public List<MemberBean> selectSome(Map<?, ?> param);
	public MemberBean selectOne(String id);
	public String count(); // 제일 간단한 쿼리로 DB와의 연결확인이 간편하다.
	
	/*
	public List<MemberBean> selectMemberAll();
	public List<MemberBean> selectMemberAll(String page);
	public List<MemberBean> selectSome(Columns column, String word);
	public MemberBean selectUser(MemberBean member);
	public List<MemberBean> selectByTeamId(String team);
	public List<MemberBean> selectByName(String name);
	public MemberBean selectById(MemberBean member);
	*/
}
