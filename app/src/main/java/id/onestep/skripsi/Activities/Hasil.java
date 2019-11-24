package id.onestep.skripsi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Adapter.HasilAdapter;
import id.onestep.skripsi.R;

public class Hasil extends AppCompatActivity {
    @BindView(R.id.rvHasil)
    RecyclerView rvHasil;
    HasilAdapter adapter;
    List<id.onestep.skripsi.Hasil> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        ButterKnife.bind(this);
        rvHasil.setHasFixedSize(true);
        rvHasil.setLayoutManager(new LinearLayoutManager(this));
        getHasil();
    }

    private void getHasil() {
        list.add(new id.onestep.skripsi.Hasil("Padi", "Sangat Sesuai", 90));
        list.add(new id.onestep.skripsi.Hasil("Jagung", "Sangat Sesuai", 80));
        list.add(new id.onestep.skripsi.Hasil("Ubi Kayu", "Cukup Sesuai", 70));
        list.add(new id.onestep.skripsi.Hasil("Ubi Jalar", "Cukup Sesuai", 65));
        list.add(new id.onestep.skripsi.Hasil("Kacang Tanah", "Rata rata", 45));
        list.add(new id.onestep.skripsi.Hasil("Talas", "Tidak Sesuai", 20));
        adapter = new HasilAdapter(this, list);
        rvHasil.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
