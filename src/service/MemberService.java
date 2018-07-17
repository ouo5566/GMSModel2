package service;
import java.util.List;
import domain.*;

public interface MemberService {
	public void createMember(MemberBean member);
	public List<MemberBean> list();
	public boolean findByOverlabId(String id);
	public MemberBean findById(String id);
	public String memberCount();
	public void modifyMember(MemberBean member);
	public void removeMember(MemberBean member);
	public boolean login(MemberBean member);
	public boolean findByUser(MemberBean member);
	public List<MemberBean> findByTeamId(String team);
}
