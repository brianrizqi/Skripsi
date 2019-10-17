package id.onestep.skripsi.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    //php artisan serve --host 0.0.0.0 -> run cmd
    private static final String BASE_URL = "http://10.132.6.216:8000/api/"; // ipconfig cmd
    public static final String BASE_URL_STORAGE = "http://10.132.6.216:8000/storage/";
    private static Service mInstance;
    private Retrofit retrofit;

    public Service() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized Service getInstance() {
        if (mInstance == null) {
            mInstance = new Service();
        }
        return mInstance;
    }

    public APIService getAPI() {
        return retrofit.create(APIService.class);
    }
}
