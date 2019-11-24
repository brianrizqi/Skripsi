package id.onestep.skripsi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import id.onestep.skripsi.Response.PlantResponse;
import id.onestep.skripsi.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahTanamanSPPK extends AppCompatActivity {
    @BindView(R.id.spinnerBahayaErosi)
    Spinner spinnerBahayaErosi;
    @BindView(R.id.spinnerDrainase)
    Spinner spinnerDrainase;
    @BindView(R.id.spinnerTekstur)
    Spinner spinnerTekstur;
    @BindView(R.id.spinnerRotasiTanam)
    Spinner spinnerRotasiTanam;
    List<Plant> list = new ArrayList<>();
    HashMap<Integer, Integer> spinnerMap = new HashMap<Integer, Integer>();
    @BindView(R.id.btnCek)
    RelativeLayout btnCek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_tanaman_sppk);
        ButterKnife.bind(this);
        getTanaman();
        getTekstur();
        getDrainase();
        getBahayaErosi();
        btnCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sppk();
            }
        });
    }

    private void sppk() {
        Intent i = new Intent(TambahTanamanSPPK.this, Hasil.class);
        startActivity(i);
    }

    private void getBahayaErosi() {
        String[] bahayaErosi = {"Tidak ada", "Ringan", "Sedang", "Berat"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bahayaErosi);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinnerBahayaErosi.setAdapter(spinnerArrayAdapter);
    }

    private void getDrainase() {
        String drainase[] = {"Baik"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, drainase);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinnerDrainase.setAdapter(spinnerArrayAdapter);
    }

    private void getTekstur() {
        String tekstur[] = {"Halus", "Agak Halus", "Agak Kasar", "Kasar"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tekstur);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinnerTekstur.setAdapter(spinnerArrayAdapter);
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
                spinnerRotasiTanam.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<PlantResponse> call, Throwable t) {
                Toast.makeText(TambahTanamanSPPK.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
