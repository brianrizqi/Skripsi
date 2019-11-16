package id.onestep.skripsi.Service;

import id.onestep.skripsi.Response.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIWeather {
    @GET("5day/203179?")
    Call<WeatherResponse> getWeather(
            @Query("apikey") String apikey,
            @Query("language") String language,
            @Query("details") boolean details,
            @Query("metric") boolean metric
    );

    @GET("1day/203179?")
    Call<WeatherResponse> getCurrentWeather(
            @Query("apikey") String apikey,
            @Query("language") String language,
            @Query("details") boolean details,
            @Query("metric") boolean metric
    );
}
