package id.onestep.skripsi.Response;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import id.onestep.skripsi.Models.Article;

public class ArticleResponse implements Serializable {

    @SerializedName("data")
    private List<Article> data;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public void setData(List<Article> data) {
        this.data = data;
    }

    public List<Article> getData() {
        return data;
    }

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

    @Override
    public String toString() {
        return
                "ArticleResponse{" +
                        "data = '" + data + '\'' +
                        ",error = '" + error + '\'' +
                        ",message = '" + message + '\'' +
                        "}";
    }
}