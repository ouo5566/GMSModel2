package service;
import java.util.List;

import dao.MemberDAOImpl;
import domain.*;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}

	@Override
	public void createMember(MemberBean member) {
		MemberDAOImpl.getInstance().insertMember(member);
	}

	@Override
	public List<MemberBean> list() {
		return MemberDAOImpl.getInstance().selectMemberAll();
	}

	@Override
	public boolean findByOverlabId(String id) {
		return (MemberDAOImpl.getInstance().selectById(id)==null);
	}
	
	@Override
	public MemberBean findById(String id) {
		return MemberDAOImpl.getInstance().selectById(id);
	}

	@Override
	public List<MemberBean> findByTeamId(String team){
		return MemberDAOImpl.getInstance().selectByTeamId(team);
	}
	
	@Override
	public String memberCount() {
		return MemberDAOImpl.getInstance().selectMemberCount();
	}

	@Override
	public void modifyMember(MemberBean member) {
		MemberDAOImpl.getInstance().updateMember(member);
	}

	@Override
	public void removeMember(MemberBean member) {
		MemberDAOImpl.getInstance().deleteMember(member);
	}
	@Override
	public boolean login(MemberBean member) {
		return (MemberDAOImpl.getInstance().login(member)!=null);
		// null 도 주소값을 가지고 있다. 직접 그 주소값에 가서 뒤져야 하기 때문에 null을 Script까지 가져가는건 좋지 않다.
	}
	@Override
	public boolean findByUser(MemberBean member){
		return (MemberDAOImpl.getInstance().selectUser(member)==null);
	}

}
