package dao;

import domain.ImageBean;

public interface ImageDAO {
	public void insertImage(ImageBean image);
	public ImageBean selectOne(String userid);
}
