package id.onestep.skripsi.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import id.onestep.skripsi.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlantFragment extends Fragment {


    public PlantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}
