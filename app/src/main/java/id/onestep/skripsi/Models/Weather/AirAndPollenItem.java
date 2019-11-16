package id.onestep.skripsi.Models.Weather;

import com.google.gson.annotations.SerializedName;

public class AirAndPollenItem{

	@SerializedName("Category")
	private String category;

	@SerializedName("Value")
	private int value;

	@SerializedName("CategoryValue")
	private int categoryValue;

	@SerializedName("Name")
	private String name;

	@SerializedName("Type")
	private String type;

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setValue(int value){
		this.value = value;
	}

	public int getValue(){
		return value;
	}

	public void setCategoryValue(int categoryValue){
		this.categoryValue = categoryValue;
	}

	public int getCategoryValue(){
		return categoryValue;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"AirAndPollenItem{" + 
			"category = '" + category + '\'' + 
			",value = '" + value + '\'' + 
			",categoryValue = '" + categoryValue + '\'' + 
			",name = '" + name + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}