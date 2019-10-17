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
import id.onestep.skripsi.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    @BindView(R.id.greeting)
    ImageView greeting;
    @BindView(R.id.txtGreeting)
    TextView txtGreeting;
    @BindView(R.id.bgTextGreeting)
    RelativeLayout bgTextGreeting;
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

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
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
                adapter = new ArticleAdapter(getActivity(), list);
                rvArticle.setAdapter(adapter);
                adapter.notifyDataSetChanged();
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
        } else if (timeOfDay >= 12 && timeOfDay < 18) {
            Glide.with(getActivity())
                    .load(R.mipmap.afternoon)
                    .into(greeting);
            txtGreeting.setText("Selamat Siang");
            bgTextGreeting.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorBgAfternoon));
            window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.colorBgAfternoon));
        } else if (timeOfDay >= 18 && timeOfDay < 24) {
            Glide.with(getActivity())
                    .load(R.mipmap.night)
                    .into(greeting);
            txtGreeting.setText("Selamat Malam");
            bgTextGreeting.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorBgNight));
            window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.colorBgNight));
        }
    }
}
