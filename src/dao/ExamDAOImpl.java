package dao;

import java.util.ArrayList;
import java.util.List;
import domain.*;

public class ExamDAOImpl implements ExamDAO{
	private static ExamDAO instance = new ExamDAOImpl();
	public static ExamDAO getInstance() {return instance;}
	private ExamDAOImpl() {}
	
	@Override
	public void insertExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<ExamBean> selectExamAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ExamBean> selectByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ExamBean selectByID(ExamBean exam) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String selectExamCount() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}
	}
