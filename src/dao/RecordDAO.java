package dao;
import java.util.List;
import domain.*;

public interface RecordDAO {
	public void insertRecord(RecordBean record);
	public List<RecordBean> selectRecordAll();
	public List<RecordBean> selectByWord(String word);
	public RecordBean selectById(RecordBean record);
	public String selectRecordCount();
	public void updateRecord(RecordBean record);
	public void deleteRecord(RecordBean record);
	public String selectLastRowNum();
}
