package id.onestep.skripsi.Service;


import id.onestep.skripsi.Models.Weathers;
import id.onestep.skripsi.Response.ArticleResponse;
import id.onestep.skripsi.Response.DefaultResponse;
import id.onestep.skripsi.Response.LahanResponse;
import id.onestep.skripsi.Response.LoginResponse;
import id.onestep.skripsi.Response.PlantResponse;
import id.onestep.skripsi.Response.TanamanResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

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

    @GET("area/{user_id}")
    Call<LahanResponse> getLahan(
            @Path("user_id") int user_id
    );

    @FormUrlEncoded
    @POST("area")
    Call<DefaultResponse> addLahan(
            @Field("user_id") int user_id,
            @Field("large") int large
    );

    @GET("planting/{area_id}")
    Call<TanamanResponse> getTanaman(
            @Path("area_id") int area_id
    );

    @GET("plant")
    Call<PlantResponse> getTumbuhan();

    @FormUrlEncoded
    @POST("planting")
    Call<DefaultResponse> addTanamanManual(
            @Field("area_id") int area_id,
            @Field("plant_id") int plant_id
    );

    @FormUrlEncoded
    @POST("planting/{planting_id}/edit")
    Call<DefaultResponse> verifTanaman(
            @Path("planting_id") int planting_id,
            @Field("pemasukan") int pemasukan,
            @Field("pengeluaran") int pengeluaran
    );
}
