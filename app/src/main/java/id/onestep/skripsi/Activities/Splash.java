package id.onestep.skripsi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Others.TinyDB;
import id.onestep.skripsi.R;

public class Splash extends AppCompatActivity {
    @BindView(R.id.btnLogin)
    RelativeLayout btnLogin;
    @BindView(R.id.btnRegis)
    RelativeLayout btnRegis;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tinyDB = new TinyDB(this);
        ButterKnife.bind(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regis();
            }
        });
    }

    private void login() {
        Intent i = new Intent(Splash.this, Masuk.class);
        startActivity(i);
    }

    private void regis() {
        Intent i = new Intent(Splash.this, Daftar.class);
        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (tinyDB.getBoolean("isLogin")) {
            Intent i = new Intent(Splash.this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
            finish();
        }
    }
}
