package dao;

import java.util.List;

import domain.SubjectBean;

public class SubjectDAOImpl implements SubjectDAO{
	private static SubjectDAO instance = new SubjectDAOImpl();
	public static SubjectDAO getInstance() {return instance;}
	private SubjectDAOImpl() {}
	@Override
	public void insertSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<SubjectBean> selectSubjectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SubjectBean> selectByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SubjectBean selectById(SubjectBean subjectBean) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String selectSubjectCount() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

}
