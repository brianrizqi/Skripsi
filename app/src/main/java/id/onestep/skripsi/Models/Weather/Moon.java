package id.onestep.skripsi.Models.Weather;

import com.google.gson.annotations.SerializedName;

public class Moon{

	@SerializedName("EpochSet")
	private int epochSet;

	@SerializedName("Set")
	private String set;

	@SerializedName("Phase")
	private String phase;

	@SerializedName("EpochRise")
	private int epochRise;

	@SerializedName("Age")
	private int age;

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

	public void setPhase(String phase){
		this.phase = phase;
	}

	public String getPhase(){
		return phase;
	}

	public void setEpochRise(int epochRise){
		this.epochRise = epochRise;
	}

	public int getEpochRise(){
		return epochRise;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return age;
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
			"Moon{" + 
			"epochSet = '" + epochSet + '\'' + 
			",set = '" + set + '\'' + 
			",phase = '" + phase + '\'' + 
			",epochRise = '" + epochRise + '\'' + 
			",age = '" + age + '\'' + 
			",rise = '" + rise + '\'' + 
			"}";
		}
}