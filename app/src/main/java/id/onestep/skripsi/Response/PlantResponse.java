package id.onestep.skripsi.Response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import id.onestep.skripsi.Models.Plant;

public class PlantResponse{

	@SerializedName("data")
	private List<Plant> data;

	@SerializedName("message")
	private String message;

	@SerializedName("error")
	private boolean error;

	public void setData(List<Plant> data){
		this.data = data;
	}

	public List<Plant> getData(){
		return data;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	@Override
 	public String toString(){
		return 
			"PlantResponse{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",error = '" + error + '\'' + 
			"}";
		}
}