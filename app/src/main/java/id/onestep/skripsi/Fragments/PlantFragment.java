package id.onestep.skripsi.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.R;
import id.onestep.skripsi.Response.WeatherResponse;
import id.onestep.skripsi.Service.WeatherService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlantFragment extends Fragment {
    private static final String TAG = PlantFragment.class.getSimpleName();
    @BindView(R.id.txt)
    TextView txt;
    double cuaca;

    public PlantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant, container, false);
        ButterKnife.bind(this, view);
        getWeather();
        return view;
    }

    private void getWeather() {
        String apikey = "OwA3GRiw3IHI0snDLPhcW4HxJ5AkFbrS";
        String language = "id-id";
        boolean details = true;
        boolean metric = true;
        Call<WeatherResponse> call = WeatherService
                .getInstance()
                .getAPI()
                .getWeather(
                        apikey,
                        language,
                        details,
                        metric
                );
        Log.d(TAG, "getWeather: " + call.request());
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                for (int i = 0; i < 5; i++) {
                    Log.d(TAG, "onResponse: " + response.body().getDailyForecasts().get(i).getTemperature().getMaximum().getValue());
                    cuaca += response.body().getDailyForecasts().get(i).getTemperature().getMaximum().getValue();
                }
                Log.d(TAG, "onResponse: cuaca 5 hari = " + cuaca / 5);
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
                Log.d(TAG, "onFailure: " + t.getMessage());
                Log.d(TAG, "onFailure: " + t.getCause());
                Log.d(TAG, "onFailure: " + t.getStackTrace());
                Log.d(TAG, "onFailure: " + t.getSuppressed());
            }
        });
    }

}
