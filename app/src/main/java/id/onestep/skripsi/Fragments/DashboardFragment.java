package id.onestep.skripsi.Fragments;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Adapter.ArticleAdapter;
import id.onestep.skripsi.Models.Article;
import id.onestep.skripsi.R;
import id.onestep.skripsi.Response.ArticleResponse;
import id.onestep.skripsi.Response.WeatherResponse;
import id.onestep.skripsi.Service.Service;
import id.onestep.skripsi.Service.WeatherService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    @BindView(R.id.imgNoData)
    ImageView imgNoData;
    @BindView(R.id.greeting)
    ImageView greeting;
    @BindView(R.id.txtGreeting)
    TextView txtGreeting;
    @BindView(R.id.bgTextGreeting)
    RelativeLayout bgTextGreeting;
//    @BindView(R.id.txtCuaca)
//    TextView txtCuaca;
//    @BindView(R.id.imgCuaca)
//    ImageView imgCuaca;
//    @BindView(R.id.txtSuhu)
//    TextView txtSuhu;
    @BindView(R.id.rvArticle)
    RecyclerView rvArticle;
    ArticleAdapter adapter;
    List<Article> list = new ArrayList<>();

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);
        Window window = getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        greeting(window);
        rvArticle.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvArticle.setHasFixedSize(true);
        getArticle();
        return view;
    }

    private void getArticle() {
        Call<ArticleResponse> call = Service
                .getInstance()
                .getAPI()
                .getArticle();
        call.enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                list = response.body().getData();
                if (list.size() == 0) {
                    imgNoData.setVisibility(View.VISIBLE);
                } else {
                    adapter = new ArticleAdapter(getActivity(), list);
                    rvArticle.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void greeting(Window window) {
        Calendar calendar = Calendar.getInstance();
        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 12) {
            Glide.with(getActivity())
                    .load(R.mipmap.morning)
                    .into(greeting);
            txtGreeting.setText("Selamat Pagi");
            bgTextGreeting.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorBgMorning));
            window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.colorBgMorning));
//            txtCuaca.setText("Hari Ini");
//            Glide.with(getActivity())
//                    .load("https://www.accuweather.com/images/weathericons/6.svg")
//                    .into(imgCuaca);
        } else if (timeOfDay >= 12 && timeOfDay < 18) {
            Glide.with(getActivity())
                    .load(R.mipmap.afternoon)
                    .into(greeting);
            txtGreeting.setText("Selamat Siang");
            bgTextGreeting.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorBgAfternoon));
            window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.colorBgAfternoon));
//            txtCuaca.setText("Hari Ini");
//            Glide.with(getActivity())
//                    .load("https://www.accuweather.com/images/weathericons/6.svg")
//                    .into(imgCuaca);
        } else if (timeOfDay >= 18 && timeOfDay < 24) {
            Glide.with(getActivity())
                    .load(R.mipmap.night)
                    .into(greeting);
            txtGreeting.setText("Selamat Malam");
            bgTextGreeting.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorBgNight));
            window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.colorBgNight));
//            txtCuaca.setText("Malam Ini");
//            Glide.with(getActivity())
//                    .load("https://www.accuweather.com/images/weathericons/34.svg")
//                    .into(imgCuaca);
        }
//        getWeather(timeOfDay);
    }

//    private void getWeather(int timeOfDay) {
//        String apikey = "uVvLKySk6THbf19xlGxG1fFzN9AO2C89";
//        String language = "id-id";
//        boolean details = true;
//        boolean metric = true;
//        Call<WeatherResponse> call = WeatherService
//                .getInstance()
//                .getAPI()
//                .getCurrentWeather(
//                        apikey,
//                        language,
//                        details,
//                        metric
//                );
//        call.enqueue(new Callback<WeatherResponse>() {
//            @Override
//            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
//                if (timeOfDay >= 0 && timeOfDay < 18) {
//                    txtSuhu.setText(String.valueOf(
//                            (response.body().getDailyForecasts().get(0).getTemperature().getMaximum().getValue() + response.body().getDailyForecasts().get(0).getTemperature().getMinimum().getValue()) / 2
//                    ));
//                } else if (timeOfDay >= 18 && timeOfDay < 24) {
//                    txtSuhu.setText(String.valueOf(response.body().getDailyForecasts().get(0).getTemperature().getMinimum().getValue()));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<WeatherResponse> call, Throwable t) {
//                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
