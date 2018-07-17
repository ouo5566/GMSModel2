package service;
import java.util.List;
import domain.*;

public interface ExamService {
	public void createExam(ExamBean exam);
	public List<ExamBean> examList();
	public List<ExamBean> searchByWord(String word);
	public ExamBean searchById(ExamBean exam);
	public String examCount();
	public void modifyExam(ExamBean exam);
	public void removeExam(ExamBean exam);
}
