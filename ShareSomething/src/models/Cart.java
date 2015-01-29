package models;

import java.util.ArrayList;
import java.util.List;

import facades.ImagesFacade;

public class Cart {
	ArrayList<Image> images = new ArrayList<Image>();
	
	public void addImage(long id) {
		images.add(ImagesFacade.searchById(id));
	}
	
	public boolean removeImage(Image image) {
		return removeImageById(image.getId());
	}
	
	public boolean removeImageById(long id) {
		for (int i=0; i < this.images.size(); i++) {
			if (images.get(i).getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public List<Image> list() {
		return this.images;
	}
}
