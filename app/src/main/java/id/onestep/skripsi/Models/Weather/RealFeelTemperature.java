package id.onestep.skripsi.Models.Weather;

import com.google.gson.annotations.SerializedName;

public class RealFeelTemperature{

	@SerializedName("Minimum")
	private Minimum minimum;

	@SerializedName("Maximum")
	private Maximum maximum;

	public void setMinimum(Minimum minimum){
		this.minimum = minimum;
	}

	public Minimum getMinimum(){
		return minimum;
	}

	public void setMaximum(Maximum maximum){
		this.maximum = maximum;
	}

	public Maximum getMaximum(){
		return maximum;
	}

	@Override
 	public String toString(){
		return 
			"RealFeelTemperature{" + 
			"minimum = '" + minimum + '\'' + 
			",maximum = '" + maximum + '\'' + 
			"}";
		}
}