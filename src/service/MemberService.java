package service;
import java.util.List;
import domain.*;
import enums.Columns;

public interface MemberService {
	public void createMember(MemberBean member);
	public void modifyMember(MemberBean member);
	public void removeMember(MemberBean member);
	public boolean loginFlag(MemberBean member);
	public boolean findByUser(MemberBean member);
	public List<MemberBean> list();
	public List<MemberBean> findByWord(Columns column, String word);
	public MemberBean findById(String id);
	public String memberCount();
	public MemberBean login(MemberBean member);
/*	public List<MemberBean> findByTeamId(String team);
	public List<MemberBean> findByName(String name);*/
}
