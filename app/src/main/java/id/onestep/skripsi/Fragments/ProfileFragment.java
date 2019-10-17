package id.onestep.skripsi.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinyDB.clear();
                Intent i = new Intent(getActivity(), Masuk.class);
                startActivity(i);
                getActivity().finish();
            }
        });
        return view;
    }

}
