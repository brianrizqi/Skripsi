package id.onestep.skripsi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Models.Plant;
import id.onestep.skripsi.R;
import id.onestep.skripsi.Response.DefaultResponse;
import id.onestep.skripsi.Response.PlantResponse;
import id.onestep.skripsi.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahTanamanManual extends AppCompatActivity {
    @BindView(R.id.spinnerTanaman)
    Spinner spinnerTanaman;
    List<Plant> list = new ArrayList<>();
    HashMap<Integer, Integer> spinnerMap = new HashMap<Integer, Integer>();
    @BindView(R.id.btnTambahTanaman)
    RelativeLayout btnTambahTanaman;
    int area_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_tanaman_manual);
        ButterKnife.bind(this);
        area_id = getIntent().getIntExtra("area_id", 0);
        getTanaman();
        btnTambahTanaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = spinnerMap.get(spinnerTanaman.getSelectedItemPosition());
                tambah(area_id, id);
            }
        });
    }

    private void tambah(int area_id, int id) {
        Call<DefaultResponse> call = Service
                .getInstance()
                .getAPI()
                .addTanamanManual(
                        area_id,
                        id
                );
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.body().isError()) {
                    Toast.makeText(TambahTanamanManual.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TambahTanamanManual.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    onBackPressed();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(TambahTanamanManual.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getTanaman() {
        Call<PlantResponse> call = Service
                .getInstance()
                .getAPI()
                .getTumbuhan();
        call.enqueue(new Callback<PlantResponse>() {
            @Override
            public void onResponse(Call<PlantResponse> call, Response<PlantResponse> response) {
                list = response.body().getData();
                String[] spinnerSubArray = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    spinnerMap.put(i, list.get(i).getId());
                    spinnerSubArray[i] = list.get(i).getName();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, spinnerSubArray);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerTanaman.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<PlantResponse> call, Throwable t) {
                Toast.makeText(TambahTanamanManual.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
