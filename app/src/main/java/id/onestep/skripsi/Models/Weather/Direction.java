package id.onestep.skripsi.Models.Weather;

import com.google.gson.annotations.SerializedName;

public class Direction{

	@SerializedName("English")
	private String english;

	@SerializedName("Degrees")
	private int degrees;

	@SerializedName("Localized")
	private String localized;

	public void setEnglish(String english){
		this.english = english;
	}

	public String getEnglish(){
		return english;
	}

	public void setDegrees(int degrees){
		this.degrees = degrees;
	}

	public int getDegrees(){
		return degrees;
	}

	public void setLocalized(String localized){
		this.localized = localized;
	}

	public String getLocalized(){
		return localized;
	}

	@Override
 	public String toString(){
		return 
			"Direction{" + 
			"english = '" + english + '\'' + 
			",degrees = '" + degrees + '\'' + 
			",localized = '" + localized + '\'' + 
			"}";
		}
}