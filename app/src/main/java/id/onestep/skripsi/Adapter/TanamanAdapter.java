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

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Models.Tanaman.DataItem;
import id.onestep.skripsi.R;

public class TanamanAdapter extends RecyclerView.Adapter<TanamanAdapter.ViewHolder> {
    private Context context;
    private List<DataItem> list;

    public TanamanAdapter(Context context, List<DataItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_tanaman, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataItem post = list.get(position);
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String pemasukan = formatter.format(post.getProfit());
        String pengeluaran = formatter.format(post.getLoss());
        String[] array = context.getResources().getStringArray(R.array.color);
        String randomStr = array[new Random().nextInt(array.length)];
        holder.side.setBackgroundColor(Color.parseColor(randomStr));
        holder.txtItemTanamanJudul.setText(post.getPlant().getName());
        if (post.getProfit() != 0 || post.getLoss() != 0) {
            holder.txtItemTanamanPemasukan.setText("Pemasukan : Rp. " + pemasukan);
            holder.txtItemTanamanPengeluaran.setText("Pengeluaran : Rp. " + pengeluaran);
        }
        if (post.getStatus() == 0) {
            holder.txtItemTanamanStatus.setText("Status : Tanam");
        } else {
            holder.txtItemTanamanStatus.setText("Status : Panen");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.side)
        RelativeLayout side;
        @BindView(R.id.txtItemTanamanJudul)
        TextView txtItemTanamanJudul;
        @BindView(R.id.txtItemTanamanPemasukan)
        TextView txtItemTanamanPemasukan;
        @BindView(R.id.txtItemTanamanPengeluaran)
        TextView txtItemTanamanPengeluaran;
        @BindView(R.id.txtItemTanamanStatus)
        TextView txtItemTanamanStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
