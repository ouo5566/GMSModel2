package dao;
import java.util.List;
import domain.*;

public interface SubjectDAO {
	public void insertSubject(SubjectBean subject);
	public List<SubjectBean> selectSubjectAll();
	public List<SubjectBean> selectByWord(String word);
	public SubjectBean selectById(SubjectBean subjectBean);
	public String selectSubjectCount();
	public void updateSubject(SubjectBean subject);
	public void deleteSubject(SubjectBean subject);
}
