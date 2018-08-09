package service;
import java.util.List;
import java.util.Map;

import dao.MemberDAOImpl;
import domain.*;
import enums.Columns;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}

	@Override
	public void add(MemberBean member) {
		MemberDAOImpl.getInstance().insert(member);
	}

	@Override
	public MemberBean retrieve(String id) {
		return MemberDAOImpl.getInstance().selectOne(id);
	}
	
	@Override
	public String count() {
		return MemberDAOImpl.getInstance().count();
	}

	@Override
	public void modify(Map<?, ?> param) {
		MemberDAOImpl.getInstance().update(param);
	}

	@Override
	public void remove(MemberBean member) {
		MemberDAOImpl.getInstance().delete(member);
	}
	@Override
	public boolean loginFlag(MemberBean member) {
		return (login(member)!=null);
		// null 도 주소값을 가지고 있다. 직접 그 주소값에 가서 뒤져야 하기 때문에 null을 Script까지 가져가는건 좋지 않다.
	}
	@Override
	public MemberBean login(MemberBean member) {
		return MemberDAOImpl.getInstance().login(member);
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		return MemberDAOImpl.getInstance().selectSome(param);
	}

}
