package id.onestep.skripsi.Models.Weather;

import com.google.gson.annotations.SerializedName;

public class DegreeDaySummary{

	@SerializedName("Cooling")
	private Cooling cooling;

	@SerializedName("Heating")
	private Heating heating;

	public void setCooling(Cooling cooling){
		this.cooling = cooling;
	}

	public Cooling getCooling(){
		return cooling;
	}

	public void setHeating(Heating heating){
		this.heating = heating;
	}

	public Heating getHeating(){
		return heating;
	}

	@Override
 	public String toString(){
		return 
			"DegreeDaySummary{" + 
			"cooling = '" + cooling + '\'' + 
			",heating = '" + heating + '\'' + 
			"}";
		}
}