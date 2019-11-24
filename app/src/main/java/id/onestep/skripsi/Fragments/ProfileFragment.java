package id.onestep.skripsi.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Activities.MainActivity;
import id.onestep.skripsi.Activities.Masuk;
import id.onestep.skripsi.Others.TinyDB;
import id.onestep.skripsi.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    @BindView(R.id.imgProfile)
    ImageView imgProfile;
    @BindView(R.id.txtProfileName)
    TextView txtProfileName;
    @BindView(R.id.txtProfileUsername)
    TextView txtProfileUsername;
    TinyDB tinyDB;
    @BindView(R.id.btnLogout)
    ImageView btnLogout;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        tinyDB = new TinyDB(getActivity());
        Window window = getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.colorWhite));
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinyDB.clear();
                Intent i = new Intent(getActivity(), Masuk.class);
                startActivity(i);
                getActivity().finish();
            }
        });
        getProfile(tinyDB.getInt("user_id"));
        return view;
    }

    private void getProfile(int user_id) {
        Glide.with(getActivity())
                .load("https://cdn.dribbble.com/users/504585/screenshots/2006389/terrible_designer_avatar-01.jpg")
                .into(imgProfile);
        txtProfileName.setText("Brian Rizqi");
        txtProfileUsername.setText("@brianrizqi");
    }

}
