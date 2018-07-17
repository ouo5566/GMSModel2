package service;

import java.util.ArrayList;
import java.util.List;
import domain.*;

public class SubjectServiceImpl implements SubjectService{
	private static SubjectService instance = new SubjectServiceImpl();
	public static SubjectService getInstance() {return instance;}
	private SubjectServiceImpl() {}

	@Override
	public void createSubject(SubjectBean subject) {
		
	}

	@Override
	public List<SubjectBean> list() {
		List<SubjectBean> list = new ArrayList<>();
		return list;
	}

	@Override
	public List<SubjectBean> searchSome(String word) {
		List<SubjectBean> result = new ArrayList<>();
		return result;
	}

	@Override
	public SubjectBean searchOne(SubjectBean subject) {
		SubjectBean result = new SubjectBean();
		return result;
	}

	@Override
	public String subjectCount() {
		String result = "";
		return result;
	}

	@Override
	public void modifySubject(SubjectBean subject) {
		
	}

	@Override
	public void removeSubject(SubjectBean subject) {
		
	}

}
