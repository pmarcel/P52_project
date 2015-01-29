package models;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Image
 *
 */
@Entity
public class Image implements Serializable {

	@Id @GeneratedValue long id;
	private String name;
	private String description;
	private User owner;
	private String link;
	private Category category;
	private static final long serialVersionUID = 1L;

	public Image() {
		super();
	}   
	public long getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}   
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}   
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}   
	
	public User getOwner() {
		return this.owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public String getLink() {
		return this.link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
   
}
