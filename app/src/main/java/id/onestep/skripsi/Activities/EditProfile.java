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
import id.onestep.skripsi.Response.UsersResponse;
import id.onestep.skripsi.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfile extends AppCompatActivity {
    @BindView(R.id.etName)
    TextInputEditText etName;
    @BindView(R.id.etEmail)
    TextInputEditText etEmail;
    @BindView(R.id.etUsername)
    TextInputEditText etUsername;
    @BindView(R.id.etPassword)
    TextInputEditText etPassword;
    @BindView(R.id.btnUpdate)
    RelativeLayout btnUpdate;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ButterKnife.bind(this);
        tinyDB = new TinyDB(this);
        getUser(tinyDB.getInt("user_id"));
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(tinyDB.getInt("user_id"));
            }
        });
    }

    private void update(int user_id) {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        Call<DefaultResponse> call = Service
                .getInstance()
                .getAPI()
                .updateUser(
                        user_id,
                        name,
                        email,
                        username,
                        password
                );
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                Toast.makeText(EditProfile.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                onBackPressed();
                finish();
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(EditProfile.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getUser(int user_id) {
        Call<UsersResponse> call = Service
                .getInstance()
                .getAPI()
                .getUser(user_id);
        call.enqueue(new Callback<UsersResponse>() {
            @Override
            public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {
                if (response.body().isError()) {
                    Toast.makeText(EditProfile.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    etName.setText(response.body().getData().getName());
                    etEmail.setText(response.body().getData().getEmail());
                    etUsername.setText(response.body().getData().getUsername());
                }
            }

            @Override
            public void onFailure(Call<UsersResponse> call, Throwable t) {
                Toast.makeText(EditProfile.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
