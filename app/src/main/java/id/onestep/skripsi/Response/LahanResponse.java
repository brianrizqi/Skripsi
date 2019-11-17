package id.onestep.skripsi.Response;

import java.util.List;

import id.onestep.skripsi.Models.Lahan.Lahan;

public class LahanResponse{
	private List<Lahan> data;
	private boolean error;
	private String message;

	public void setData(List<Lahan> data){
		this.data = data;
	}

	public List<Lahan> getData(){
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
			"LahanResponse{" + 
			"data = '" + data + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}