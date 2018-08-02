package dao;
import java.util.List;
import domain.*;
import enums.Columns;

public interface MemberDAO {
	public void insertMember(MemberBean member);
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public MemberBean login(MemberBean member);
	public MemberBean selectUser(MemberBean member);
	public List<MemberBean> selectMemberAll();
	public List<MemberBean> selectSome(Columns column, String word);
	public MemberBean selectById(String id);
	public String selectMemberCount(); // 제일 간단한 쿼리로 DB와의 연결확인이 간편하다.
	
	/*public List<MemberBean> selectByTeamId(String team);
	public List<MemberBean> selectByName(String name);
	public MemberBean selectById(MemberBean member);*/
}
