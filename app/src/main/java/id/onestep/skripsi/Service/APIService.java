package id.onestep.skripsi.Service;


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
            @Field("password") String password,
            @Field("username") String username,
            @Field("land_area") int luas_lahan
    );

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(
            @Field("password") String password,
            @Field("username") String username
    );

    @GET("article")
    Call<ArticleResponse> getArticle();
}
