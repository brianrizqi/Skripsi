package id.onestep.skripsi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Adapter.TanamanAdapter;
import id.onestep.skripsi.Models.Tanaman.DataItem;
import id.onestep.skripsi.R;
import id.onestep.skripsi.Response.TanamanResponse;
import id.onestep.skripsi.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tanaman extends AppCompatActivity {
    @BindView(R.id.rvTanaman)
    RecyclerView rvTanaman;
    TanamanAdapter adapter;
    List<DataItem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanaman);
        ButterKnife.bind(this);
        rvTanaman.setLayoutManager(new LinearLayoutManager(this));
        rvTanaman.setHasFixedSize(true);
        getTanaman(getIntent().getIntExtra("area_id", 0));
    }

    private void getTanaman(int area_id) {
        Call<TanamanResponse> call = Service
                .getInstance()
                .getAPI()
                .getTanaman(
                        area_id
                );
        call.enqueue(new Callback<TanamanResponse>() {
            @Override
            public void onResponse(Call<TanamanResponse> call, Response<TanamanResponse> response) {
                if (response.body().isError()) {
                    Toast.makeText(Tanaman.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    list = response.body().getData();
                    adapter = new TanamanAdapter(Tanaman.this, list);
                    rvTanaman.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<TanamanResponse> call, Throwable t) {
                Toast.makeText(Tanaman.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
