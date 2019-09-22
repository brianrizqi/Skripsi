package id.onestep.skripsi.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
        private static final String BASE_URL = "http://192.168.184.192:8000/api/";
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
