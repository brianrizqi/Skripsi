package id.onestep.skripsi.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Adapter.TanamanAdapter;
import id.onestep.skripsi.Models.Tanaman.DataItem;
import id.onestep.skripsi.R;
import id.onestep.skripsi.Response.DefaultResponse;
import id.onestep.skripsi.Response.TanamanResponse;
import id.onestep.skripsi.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tanaman extends AppCompatActivity {
    @BindView(R.id.txtTanamanLahan)
    TextView txtTanamanLahan;
    @BindView(R.id.rvTanaman)
    RecyclerView rvTanaman;
    TanamanAdapter adapter;
    List<DataItem> list = new ArrayList<>();
    @BindView(R.id.btnTambahTanaman)
    RelativeLayout btnTambahTanaman;
    @BindView(R.id.imgNoData)
    ImageView imgNoData;
    int area_id, lahan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanaman);
        ButterKnife.bind(this);
        rvTanaman.setLayoutManager(new LinearLayoutManager(this));
        rvTanaman.setHasFixedSize(true);
        lahan = getIntent().getIntExtra("lahan", 0);
        txtTanamanLahan.setText("Lahan " + lahan);
        area_id = getIntent().getIntExtra("area_id", 0);
        getTanaman(area_id);
        btnTambahTanaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLatest(area_id);
            }
        });
    }

    private void getLatest(int area_id) {
        Call<DefaultResponse> call = Service
                .getInstance()
                .getAPI()
                .getLatestPlant(area_id);
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.body().isError()) {
                    Toast.makeText(Tanaman.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                } else {
                    dialog(area_id);
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(Tanaman.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void dialog(int area_id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_tanaman, null);
        RelativeLayout btnTambahManual = (RelativeLayout) view.findViewById(R.id.btnTambahManual);
        RelativeLayout btnTambahSppk = (RelativeLayout) view.findViewById(R.id.btnTambahSppk);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
        btnTambahManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tanaman.this, TambahTanamanManual.class);
                i.putExtra("area_id", area_id);
                startActivity(i);
                dialog.dismiss();
            }
        });
        btnTambahSppk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tanaman.this, TambahTanamanSPPK.class);
                i.putExtra("lahan", lahan);
                i.putExtra("area_id", area_id);
                startActivity(i);
                dialog.dismiss();
            }
        });
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
                    imgNoData.setVisibility(View.VISIBLE);
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
