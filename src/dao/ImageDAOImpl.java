package dao;

import java.util.HashMap;
import java.util.Map;

import domain.ImageBean;
import enums.Domain;
import template.*;

public class ImageDAOImpl implements ImageDAO{
	private static ImageDAO instance = new ImageDAOImpl();
	public static ImageDAO getInstance() {return instance;}
	public ImageDAOImpl() {}
	private QueryTemplate q;
	
	@Override
	public void insertImage(ImageBean image) {
		q = new AddQuery();
		Map<String, Object> map = new HashMap<>();
		map.put("value", image);
		map.put("table", Domain.IMAGE);
		q.play(map);
	}
	@Override
	public ImageBean selectOne(String userid) {
		q = new RetrieveQuery();
		Map<String, Object> map = new HashMap<>();
		map.put("value", userid);
		map.put("table", Domain.IMAGE);
		q.play(map);
		return (ImageBean) q.getMap().get("result");
	}

}
