package id.onestep.skripsi.Models.Weather;

import com.google.gson.annotations.SerializedName;

public class Sun{

	@SerializedName("EpochSet")
	private int epochSet;

	@SerializedName("Set")
	private String set;

	@SerializedName("EpochRise")
	private int epochRise;

	@SerializedName("Rise")
	private String rise;

	public void setEpochSet(int epochSet){
		this.epochSet = epochSet;
	}

	public int getEpochSet(){
		return epochSet;
	}

	public void setSet(String set){
		this.set = set;
	}

	public String getSet(){
		return set;
	}

	public void setEpochRise(int epochRise){
		this.epochRise = epochRise;
	}

	public int getEpochRise(){
		return epochRise;
	}

	public void setRise(String rise){
		this.rise = rise;
	}

	public String getRise(){
		return rise;
	}

	@Override
 	public String toString(){
		return 
			"Sun{" + 
			"epochSet = '" + epochSet + '\'' + 
			",set = '" + set + '\'' + 
			",epochRise = '" + epochRise + '\'' + 
			",rise = '" + rise + '\'' + 
			"}";
		}
}