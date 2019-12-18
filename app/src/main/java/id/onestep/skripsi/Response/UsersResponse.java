package id.onestep.skripsi.Response;

import com.google.gson.annotations.SerializedName;

import id.onestep.skripsi.Models.Users;

public class UsersResponse{

	@SerializedName("data")
	private Users users;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public void setData(Users users){
		this.users = users;
	}

	public Users getData(){
		return users;
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
			"UsersResponse{" + 
			"data = '" + users + '\'' +
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}