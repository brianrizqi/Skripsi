package id.onestep.skripsi.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Models.Lahan.Lahan;
import id.onestep.skripsi.R;

public class LahanAdapter extends RecyclerView.Adapter<LahanAdapter.ViewHolder> {
    private Activity activity;
    private List<Lahan> list;

    public LahanAdapter(Activity activity, List<Lahan> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(activity).inflate(R.layout.item_lahan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Lahan post = list.get(position);
        String[] array = activity.getResources().getStringArray(R.array.color);
        String randomStr = array[new Random().nextInt(array.length)];
        holder.side.setBackgroundColor(Color.parseColor(randomStr));
        holder.txtItemLahanJudul.setText("Lahan " + (position + 1));
        holder.txtItemLahanLuas.setText(post.getLarge() + " HA");
        if (post.getPlantings().size() != 0) {
            holder.txtItemLahanTanaman.setText("Tanaman " + post.getPlantings().get(0).getPlant().getName());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.side)
        RelativeLayout side;
        @BindView(R.id.txtItemLahanJudul)
        TextView txtItemLahanJudul;
        @BindView(R.id.txtItemLahanLuas)
        TextView txtItemLahanLuas;
        @BindView(R.id.txtItemLahanTanaman)
        TextView txtItemLahanTanaman;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
