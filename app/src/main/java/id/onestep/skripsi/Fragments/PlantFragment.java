package id.onestep.skripsi.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Activities.TambahLahan;
import id.onestep.skripsi.Adapter.LahanAdapter;
import id.onestep.skripsi.Models.Lahan.Lahan;
import id.onestep.skripsi.Others.TinyDB;
import id.onestep.skripsi.R;
import id.onestep.skripsi.Response.LahanResponse;
import id.onestep.skripsi.Response.WeatherResponse;
import id.onestep.skripsi.Service.Service;
import id.onestep.skripsi.Service.WeatherService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlantFragment extends Fragment {
    private static final String TAG = PlantFragment.class.getSimpleName();
    @BindView(R.id.btnTambahLahan)
    RelativeLayout btnTambahLahan;
    @BindView(R.id.rvLahan)
    RecyclerView rvLahan;
    LahanAdapter adapter;
    List<Lahan> list = new ArrayList<>();
    TinyDB tinyDB;
    double cuaca;
    @BindView(R.id.imgNoData)
    ImageView imgNoData;

    public PlantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant, container, false);
        ButterKnife.bind(this, view);
        tinyDB = new TinyDB(getActivity());
        Window window = getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.colorWhite));
        rvLahan.setHasFixedSize(true);
        rvLahan.setLayoutManager(new LinearLayoutManager(getActivity()));
        getLahan(tinyDB.getInt("user_id"));
//        getWeather();
        btnTambahLahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TambahLahan.class);
                startActivity(i);
            }
        });
        return view;
    }

    private void getLahan(int user_id) {
        Call<LahanResponse> call = Service
                .getInstance()
                .getAPI()
                .getLahan(
                        user_id
                );
        call.enqueue(new Callback<LahanResponse>() {
            @Override
            public void onResponse(Call<LahanResponse> call, Response<LahanResponse> response) {
                if (response.body().isError()) {
                    imgNoData.setVisibility(View.VISIBLE);
                } else {
                    Log.d(TAG, "onResponse: " + response.body().getData());
                    list = response.body().getData();
                    adapter = new LahanAdapter(getActivity(), list);
                    rvLahan.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<LahanResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getWeather() {
        String apikey = "uVvLKySk6THbf19xlGxG1fFzN9AO2C89";
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
