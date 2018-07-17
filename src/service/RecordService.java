package service;
import java.util.List;
import domain.*;

public interface RecordService {
	public void createRecord(RecordBean record);
	public List<RecordBean> list();
	public List<RecordBean> searchSome(String word);
	public RecordBean searchOne(RecordBean record);
	public String countRecord();
	public void changeRecord();
	public void removeRecord();
	public String createAverageScore(String score);
	public String createGrade(String average);
}
