package dao;
import java.util.List;
import domain.*;

public interface MemberDAO {
	public void insertMember(MemberBean member);
	public List<MemberBean> selectMemberAll();
	public MemberBean selectById(String id);
	public List<MemberBean> selectByTeamId(String team);
	public MemberBean selectById(MemberBean member);
	public String selectMemberCount(); // 제일 간단한 쿼리로 DB와의 연결확인이 간편하다.
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public MemberBean login(MemberBean member);
	public MemberBean selectUser(MemberBean member);
}
