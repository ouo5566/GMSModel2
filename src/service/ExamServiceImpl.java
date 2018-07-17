package service;
import java.util.List;

import dao.*;
import domain.*;

public class ExamServiceImpl implements ExamService{
	private static ExamService instance = new ExamServiceImpl();
	public static ExamService getInstance() {return instance;}
	private ExamServiceImpl() {}	

	@Override
	public void createExam(ExamBean exam) {
		System.out.println("----ExamServiceImpl Start---");
		
		RecordBean record = new RecordBean();
		record.setAverage(RecordServiceImpl.getInstance().createAverageScore(exam.getScore()));
		record.setGrade(RecordServiceImpl.getInstance().createGrade(record.getAverage()));
		RecordServiceImpl.getInstance().createRecord(record);	
		System.out.println("[성적표]\n" + record);
		exam.setRecordSeq(RecordDAOImpl.getInstance().selectLastRowNum());
		
		String[] sub = {"Java","SQL","HTML5","R","Python"};
		String[] s = exam.getScore().split(",");
		
		for( int i = 0 ; i < s.length ; i++ ) {
			exam.setSubjectSeq(SubjectDAOImpl.getInstance().selectByWord(sub[i]).get(0).getSubjectSeq());
			exam.setScore(s[Integer.parseInt(exam.getSubjectSeq())]);
		System.out.println(sub[i]+" 시험결과 전송\n"+exam);
			ExamDAOImpl.getInstance().insertExam(exam);
		}
		
		System.out.println("----ExamServiceImpl End----");
		
//		System.out.println("----ExamServiceImpl----");
//		System.out.println(exam);
//		String[] scoreArr = exam.getScore().split(",");
//		exam.setSubjectSeq(SubjectDAOImpl.getInstance().selectByWord("Java").get(0).getSubjectSeq());
//		exam.setScore(scoreArr[Integer.parseInt(exam.getSubjectSeq())]);
//		RecordBean record = new RecordBean();
//		record.setAverage(average);
//		record.setGrade(grade);
//		RecordDAOImpl.getInstance().insertRecord(record);
//		exam.setRecordSeq(RecordDAOImpl.getInstance().selectLastRowNum());
//		ExamDAOImpl.getInstance().insertExam(exam);
	}
		@Override
		public List<ExamBean> examList() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public List<ExamBean> searchByWord(String word) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ExamBean searchById(ExamBean exam) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String examCount() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void modifyExam(ExamBean exam) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void removeExam(ExamBean exam) {
			// TODO Auto-generated method stub
			
		}
}

