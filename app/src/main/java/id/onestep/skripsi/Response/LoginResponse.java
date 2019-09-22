package id.onestep.skripsi.Response;

import com.google.gson.annotations.SerializedName;

import id.onestep.skripsi.Models.Users;

public class LoginResponse {
    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    @SerializedName("users")
    private Users users;

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean isError() {
        return error;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return
                "LoginResponse{" +
                        "error = '" + error + '\'' +
                        ",message = '" + message + '\'' +
                        ",users = '" + users + '\'' +
                        "}";
    }
}
