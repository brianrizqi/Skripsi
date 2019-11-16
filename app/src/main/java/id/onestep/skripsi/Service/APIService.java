package id.onestep.skripsi.Service;


import id.onestep.skripsi.Models.Weathers;
import id.onestep.skripsi.Response.ArticleResponse;
import id.onestep.skripsi.Response.DefaultResponse;
import id.onestep.skripsi.Response.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST("register")
    Call<DefaultResponse> daftar(
            @Field("name") String name,
            @Field("email") String email,
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(
            @Field("username") String username,
            @Field("password") String password
    );

    @GET("article")
    Call<ArticleResponse> getArticle();

    @GET("cuaca")
    Call<Weathers> getWeather();
}
