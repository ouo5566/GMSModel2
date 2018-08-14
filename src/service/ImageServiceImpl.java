package service;

import dao.ImageDAOImpl;
import domain.ImageBean;

public class ImageServiceImpl implements ImageService{
	private static ImageService instance = new ImageServiceImpl();
	public static ImageService getInstance() {return instance;}
	public ImageServiceImpl() {}

	@Override
	public void addImage(ImageBean image) {
		ImageDAOImpl.getInstance().insertImage(image);
	}

	@Override
	public ImageBean searchOne(String userid) {
		return ImageDAOImpl.getInstance().selectOne(userid);
	}
}
