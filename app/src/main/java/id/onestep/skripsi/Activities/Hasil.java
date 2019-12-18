package id.onestep.skripsi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Adapter.HasilAdapter;
import id.onestep.skripsi.Models.Result;
import id.onestep.skripsi.R;
import id.onestep.skripsi.Response.SPPKResponse;
import id.onestep.skripsi.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Hasil extends AppCompatActivity {
    private static final String TAG = Hasil.class.getSimpleName();
    @BindView(R.id.rvHasil)
    RecyclerView rvHasil;
    HasilAdapter adapter;
    List<Result> list = new ArrayList<>();
    String suhu, curah_hujan, tekstur_tanah, kedalaman_tanah, ph, bahaya_erosi, drainase, rotasi_tanam;
    int area_id,lahan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        ButterKnife.bind(this);
        area_id = getIntent().getIntExtra("area_id", 0);
        lahan = getIntent().getIntExtra("lahan", 0);
        suhu = getIntent().getStringExtra("suhu");
        curah_hujan = getIntent().getStringExtra("curah_hujan");
        tekstur_tanah = getIntent().getStringExtra("tekstur_tanah");
        kedalaman_tanah = getIntent().getStringExtra("kedalaman_tanah");
        ph = getIntent().getStringExtra("ph");
        bahaya_erosi = getIntent().getStringExtra("bahaya_erosi");
        drainase = getIntent().getStringExtra("drainase");
        rotasi_tanam = getIntent().getStringExtra("rotasi_tanam");
        rvHasil.setHasFixedSize(true);
        rvHasil.setLayoutManager(new LinearLayoutManager(this));
        getHasil(suhu, curah_hujan, tekstur_tanah, kedalaman_tanah, ph, bahaya_erosi, drainase, rotasi_tanam, area_id,lahan);
    }

    private void getHasil(String suhu, String curah_hujan, String tekstur_tanah, String kedalaman_tanah, String ph, String bahaya_erosi, String drainase, String rotasi_tanam, int area_id, int lahan) {
        Call<SPPKResponse> call = Service
                .getInstance()
                .getAPI()
                .sppk(
                        Double.parseDouble(suhu),
                        Double.parseDouble(curah_hujan),
                        tekstur_tanah,
                        Double.parseDouble(kedalaman_tanah),
                        Double.parseDouble(ph),
                        bahaya_erosi,
                        drainase,
                        rotasi_tanam
                );
        call.enqueue(new Callback<SPPKResponse>() {
            @Override
            public void onResponse(Call<SPPKResponse> call, Response<SPPKResponse> response) {
                list = response.body().getData();
                adapter = new HasilAdapter(Hasil.this, list, area_id,lahan);
                rvHasil.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<SPPKResponse> call, Throwable t) {

            }
        });
    }
}
