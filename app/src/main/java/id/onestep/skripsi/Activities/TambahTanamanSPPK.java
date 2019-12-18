package id.onestep.skripsi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

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
    private static final String TAG = TambahTanamanSPPK.class.getSimpleName();
    @BindView(R.id.etSuhu)
    TextInputEditText etSuhu;
    @BindView(R.id.etCurahHujan)
    TextInputEditText etCurahHujan;
    @BindView(R.id.etKedalamanTanah)
    TextInputEditText etKedalamanTanah;
    @BindView(R.id.etPH)
    TextInputEditText etPH;
    @BindView(R.id.spinnerBahayaErosi)
    Spinner spinnerBahayaErosi;
    @BindView(R.id.spinnerDrainase)
    Spinner spinnerDrainase;
    @BindView(R.id.spinnerTekstur)
    Spinner spinnerTekstur;
    @BindView(R.id.spinnerRotasiTanam)
    Spinner spinnerRotasiTanam;
    @BindView(R.id.btnCek)
    RelativeLayout btnCek;
    int area_id, lahan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_tanaman_sppk);
        ButterKnife.bind(this);
        area_id = getIntent().getIntExtra("area_id", 0);
        getTanaman();
        getTekstur();
        getDrainase();
        getBahayaErosi();
        btnCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sppk(area_id, lahan);
            }
        });
    }

    private void sppk(int area_id, int lahan) {
        String suhu = etSuhu.getText().toString();
        if (suhu.isEmpty()) {
            etSuhu.setError("Suhu is required");
            etSuhu.requestFocus();
            return;
        }
        String curah_hujan = etCurahHujan.getText().toString();
        if (curah_hujan.isEmpty()) {
            etCurahHujan.setError("Curah Hujan is required");
            etCurahHujan.requestFocus();
            return;
        }
        String tekstur_tanah = spinnerTekstur.getSelectedItem().toString();
        String kedalaman_tanah = etKedalamanTanah.getText().toString();
        if (kedalaman_tanah.isEmpty()) {
            etKedalamanTanah.setError("Kedalaman Tanah is required");
            etKedalamanTanah.requestFocus();
            return;
        }
        String ph = etPH.getText().toString();
        if (ph.isEmpty()) {
            etPH.setError("PH is required");
            etPH.requestFocus();
            return;
        }
        String bahaya_erosi = spinnerBahayaErosi.getSelectedItem().toString();
        String drainase = spinnerDrainase.getSelectedItem().toString();
        String rotasi_tanam = spinnerRotasiTanam.getSelectedItem().toString();
        Intent i = new Intent(TambahTanamanSPPK.this, Hasil.class);
        i.putExtra("area_id", area_id);
        i.putExtra("lahan", lahan);
        i.putExtra("suhu", suhu);
        i.putExtra("curah_hujan", curah_hujan);
        i.putExtra("tekstur_tanah", tekstur_tanah);
        i.putExtra("kedalaman_tanah", kedalaman_tanah);
        i.putExtra("ph", ph);
        i.putExtra("bahaya_erosi", bahaya_erosi);
        i.putExtra("drainase", drainase);
        i.putExtra("rotasi_tanam", rotasi_tanam);
        startActivity(i);
    }

    private void getBahayaErosi() {
        String[] bahayaErosi = {"Tidak ada", "Ringan", "Sedang", "Berat"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bahayaErosi);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinnerBahayaErosi.setAdapter(spinnerArrayAdapter);
    }

    private void getDrainase() {
        String drainase[] = {"Terhambat", "Agak Terhambat", "Agak Cepat", "Cepat", "Baik"};
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
        String tekstur[] = {"Padi", "Jagung", "Ubi Jalar", "Ubi Kayu", "Talas", "Kacang Tanah"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tekstur);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinnerRotasiTanam.setAdapter(spinnerArrayAdapter);
    }
}
