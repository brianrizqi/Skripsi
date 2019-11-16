package id.onestep.skripsi.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherService {
    private static final String BASE_URL = "http://dataservice.accuweather.com/forecasts/v1/daily/";
    private static WeatherService mInstance;
    private Retrofit retrofit;

    public WeatherService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized WeatherService getInstance() {
        if (mInstance == null) {
            mInstance = new WeatherService();
        }
        return mInstance;
    }

    public APIWeather getAPI() {
        return retrofit.create(APIWeather.class);
    }
}
