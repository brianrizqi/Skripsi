package id.onestep.skripsi.Service;


import id.onestep.skripsi.Response.DefaultResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST("users")
    Call<DefaultResponse> daftar(
            @Field("nama") String nama,
            @Field("email") String email,
            @Field("password") String password,
            @Field("alamat") String alamat,
            @Field("kota") String kota,
            @Field("luas_lahan") int luas_lahan
    );
}
