package dao;

import java.util.ArrayList;
import java.util.List;
import domain.*;

public class RecordDAOImpl implements RecordDAO{
	private static RecordDAO instance = new RecordDAOImpl();
	public static RecordDAO getInstance() {return instance;}
	private RecordDAOImpl() {}
	@Override
	public void insertRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<RecordBean> selectRecordAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<RecordBean> selectByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public RecordBean selectById(RecordBean record) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String selectRecordCount() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String selectLastRowNum() {
		// TODO Auto-generated method stub
		return null;
	}

}
