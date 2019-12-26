package id.onestep.skripsi.Response;

import com.google.gson.annotations.SerializedName;

import id.onestep.skripsi.Models.Lahan.Lahan;

public class LahanEditResponse{

	@SerializedName("data")
	private Lahan data;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public void setData(Lahan data){
		this.data = data;
	}

	public Lahan getData(){
		return data;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"LahanEditResponse{" + 
			"data = '" + data + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}