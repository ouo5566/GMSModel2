package service;

import domain.ImageBean;

public interface ImageService {
	public void addImage(ImageBean image);
	public ImageBean searchOne(String userid);
}
