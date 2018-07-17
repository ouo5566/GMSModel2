package service;
import java.util.List;
import domain.*;

public interface SubjectService {
	public void createSubject(SubjectBean subject);
	public List<SubjectBean> list();
	public List<SubjectBean> searchSome(String word);
	public SubjectBean searchOne(SubjectBean subject);
	public String subjectCount();
	public void modifySubject(SubjectBean subject);
	public void removeSubject(SubjectBean subject);
}
