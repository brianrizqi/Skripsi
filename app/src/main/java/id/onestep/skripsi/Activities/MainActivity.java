package id.onestep.skripsi.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Fragments.DashboardFragment;
import id.onestep.skripsi.Fragments.PlantFragment;
import id.onestep.skripsi.Fragments.ProfileFragment;
import id.onestep.skripsi.Others.BottomNavigationHelper;
import id.onestep.skripsi.Others.TinyDB;
import id.onestep.skripsi.R;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.fragment)
    RelativeLayout fragment;
    Fragment dashboard, plant, profile;

    private BottomNavigationView.OnNavigationItemSelectedListener listener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
                    fragment = dashboard;
                    if (fragment == null) {
                        dashboard = new DashboardFragment();
                    }
                    break;
                case R.id.navigation_plant:
                    fragment = plant;
                    if (fragment == null) {
                        plant = new PlantFragment();
                        fragment = plant;
                    }
                    break;
                case R.id.navigation_profile:
                    fragment = profile;
                    if (fragment == null) {
                        profile = new ProfileFragment();
                        fragment = profile;
                    }
                    break;
            }
            if (fragment != null)
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
            return fragment != null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DashboardFragment dashboardFragment = new DashboardFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, dashboardFragment);
        fragmentTransaction.commit();


        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.bottomNav);
        navigationView.setOnNavigationItemSelectedListener(listener);
        BottomNavigationHelper.disableShiftMode(navigationView);
    }
}
