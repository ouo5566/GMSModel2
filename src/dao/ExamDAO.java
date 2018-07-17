package dao;
import java.util.List;
import domain.*;

public interface ExamDAO {
	public void insertExam(ExamBean exam);
	public List<ExamBean> selectExamAll();
	public List<ExamBean> selectByWord(String word);
	public ExamBean selectByID(ExamBean exam);
	public String selectExamCount();
	public void updateExam(ExamBean exam);
	public void deleteExam(ExamBean exam);	
}
