package service;
import java.util.ArrayList;
import java.util.List;

import dao.RecordDAO;
import dao.RecordDAOImpl;
import domain.*;

public class RecordServiceImpl implements RecordService{
	private static RecordService instance = new RecordServiceImpl();
	public static RecordService getInstance() {return instance;}
	private RecordServiceImpl() {}

	@Override
	public void createRecord(RecordBean record) {
		RecordDAOImpl.getInstance().insertRecord(record);
	}

	@Override
	public List<RecordBean> list() {
		List<RecordBean> list = new ArrayList<>();
		return list;
	}

	@Override
	public List<RecordBean> searchSome(String word) {
		List<RecordBean> result = new ArrayList<>();
		return result;
	}

	@Override
	public RecordBean searchOne(RecordBean record) {
		RecordBean result = new RecordBean();
		return result;
	}

	@Override
	public String countRecord() {
		String result = "";
		return result;
	}

	@Override
	public void changeRecord() {
		
	}

	@Override
	public void removeRecord() {
		
	}
	@Override
	public String createAverageScore(String score) {
		String[] s = score.split(",");
		return String.valueOf((Integer.parseInt(s[0])+
				Integer.parseInt(s[1])+
				Integer.parseInt(s[2])+
				Integer.parseInt(s[3])+
				Integer.parseInt(s[4]))/s.length);
	}
	@Override
	public String createGrade(String average) {
		String grade = "F";
		switch(Integer.parseInt(average)/10) {
		case 10 :
		case 9 : grade = "A"; break;
		case 8 : grade = "B"; break;
		case 7 : grade = "C"; break;
		case 6 : grade = "D"; break;		
		}
		return grade;
	}
	
}
