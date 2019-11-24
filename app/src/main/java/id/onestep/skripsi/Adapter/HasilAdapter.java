package id.onestep.skripsi.Adapter;

import android.content.Context;
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
import id.onestep.skripsi.Hasil;
import id.onestep.skripsi.R;

public class HasilAdapter extends RecyclerView.Adapter<HasilAdapter.ViewHolder> {
    private Context context;
    private List<Hasil> list;

    public HasilAdapter(Context context, List<Hasil> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_hasil, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Hasil post = list.get(position);
        String[] array = context.getResources().getStringArray(R.array.color);
        String randomStr = array[new Random().nextInt(array.length)];
        holder.side.setBackgroundColor(Color.parseColor(randomStr));
        holder.txtItemHasilTanaman.setText(post.getTanaman());
        holder.txtItemHasil.setText(post.getHasil());
        holder.txtItemHasilPresentase.setText("Presentase : " + post.getPresentase() + "%");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtItemHasilTanaman)
        TextView txtItemHasilTanaman;
        @BindView(R.id.txtItemHasil)
        TextView txtItemHasil;
        @BindView(R.id.txtItemHasilPresentase)
        TextView txtItemHasilPresentase;
        @BindView(R.id.side)
        RelativeLayout side;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}