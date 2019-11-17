package id.onestep.skripsi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Others.TinyDB;
import id.onestep.skripsi.R;
import id.onestep.skripsi.Response.DefaultResponse;
import id.onestep.skripsi.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahLahan extends AppCompatActivity {
    @BindView(R.id.etLarge)
    TextInputEditText etLarge;
    @BindView(R.id.btnTambahLahan)
    RelativeLayout btnTambahLahan;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_lahan);
        ButterKnife.bind(this);
        tinyDB = new TinyDB(this);
        btnTambahLahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahLahan(tinyDB.getInt("user_id"));
            }
        });
    }

    private void tambahLahan(int user_id) {
        String large = etLarge.getText().toString().trim();
        if (large.isEmpty()) {
            etLarge.setError("Luas lahan is required");
            etLarge.requestFocus();
            return;
        }
        Call<DefaultResponse> call = Service
                .getInstance()
                .getAPI()
                .addLahan(
                        user_id,
                        Integer.parseInt(large)
                );
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.body().isError()) {
                    Toast.makeText(TambahLahan.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TambahLahan.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    onBackPressed();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(TambahLahan.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
