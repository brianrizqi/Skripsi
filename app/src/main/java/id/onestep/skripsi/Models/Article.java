package id.onestep.skripsi.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Article implements Serializable {

	@SerializedName("img")
	private String img;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("article")
	private String article;

	public void setImg(String img){
		this.img = img;
	}

	public String getImg(){
		return img;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setArticle(String article){
		this.article = article;
	}

	public String getArticle(){
		return article;
	}

	@Override
 	public String toString(){
		return 
			"Article{" +
			"img = '" + img + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",article = '" + article + '\'' + 
			"}";
		}
}