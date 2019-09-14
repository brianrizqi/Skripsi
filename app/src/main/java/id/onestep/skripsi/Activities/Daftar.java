package id.onestep.skripsi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.R;
import id.onestep.skripsi.Response.DefaultResponse;
import id.onestep.skripsi.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Daftar extends AppCompatActivity {
    @BindView(R.id.btnKembali)
    ImageView btnKembali;
    @BindView(R.id.etNama)
    TextInputEditText etNama;
    @BindView(R.id.etEmail)
    TextInputEditText etEmail;
    @BindView(R.id.etPassword)
    TextInputEditText etPassword;
    @BindView(R.id.etKota)
    TextInputEditText etKota;
    @BindView(R.id.etAlamat)
    TextInputEditText etAlamat;
    @BindView(R.id.etLuasLahan)
    TextInputEditText etLuasLahan;
    @BindView(R.id.btnDaftar)
    Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        ButterKnife.bind(this);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                finish();
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daftar();
            }
        });
    }

    private void daftar() {
        String nama = etNama.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String kota = etKota.getText().toString().trim();
        String alamat = etAlamat.getText().toString().trim();
        int luasLahan = Integer.parseInt(etLuasLahan.getText().toString());

        Call<DefaultResponse> call = Service
                .getInstance()
                .getAPI()
                .daftar(nama, email, password, alamat, kota, luasLahan);
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (!response.body().isError()) {
                    Toast.makeText(Daftar.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Daftar.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(Daftar.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
