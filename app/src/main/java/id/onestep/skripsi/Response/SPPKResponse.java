package id.onestep.skripsi.Response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import id.onestep.skripsi.Models.Result;

public class SPPKResponse{

	@SerializedName("data")
	private List<Result> data;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public void setData(List<Result> data){
		this.data = data;
	}

	public List<Result> getData(){
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
			"SPPKResponse{" + 
			"data = '" + data + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}