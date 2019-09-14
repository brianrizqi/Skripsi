package id.onestep.skripsi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.R;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btnDaftar)
    CardView btnDaftar;
    @BindView(R.id.btnMasuk)
    CardView btnMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Daftar.class);
                startActivity(i);
            }
        });
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Masuk.class);
                startActivity(i);
            }
        });
    }
}
