package id.onestep.skripsi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Models.Result;
import id.onestep.skripsi.R;

public class HasilAdapter extends RecyclerView.Adapter<HasilAdapter.ViewHolder> {
    private Context context;
    private List<Result> list;

    public HasilAdapter(Context context, List<Result> list) {
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
        final Result post = list.get(position);
        holder.itemView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade));
        String[] array = context.getResources().getStringArray(R.array.color);
        String randomStr = array[new Random().nextInt(array.length)];
        if (post.getHasil().equalsIgnoreCase("sangat sesuai")) {
            holder.side.setBackgroundResource(R.color.colorPrimary);
        } else if (post.getHasil().equalsIgnoreCase("cukup sesuai")) {
            holder.side.setBackgroundResource(R.color.colorOrange);
        } else if (post.getHasil().equalsIgnoreCase("Rata-rata")) {
            holder.side.setBackgroundResource(R.color.colorYellow);
        } else if (post.getHasil().equalsIgnoreCase("tidak sesuai")) {
            holder.side.setBackgroundResource(R.color.colorRed);
        }
        holder.txtItemHasilTanaman.setText(post.getTanaman());
        holder.txtItemHasil.setText(post.getHasil());
        holder.txtItemHasilPresentase.setText("Presentase : " + post.getNormalisasi() + "%");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog(post.getTanaman(), post.getId());
            }
        });
    }

    private void dialog(String tanaman, int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_verifikasi_hasil, null);
        RelativeLayout btnDialogHasilTambah = (RelativeLayout) view.findViewById(R.id.btnDialogHasilTambah);
        RelativeLayout btnDialogHasilBatal = (RelativeLayout) view.findViewById(R.id.btnDialogHasilBatal);
        TextView txtDialogHasil = (TextView) view.findViewById(R.id.txtDialogHasil);
        txtDialogHasil.setText("Apakah tanaman " + tanaman + " akan ditanam untuk periode selanjutnya ?");
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
        btnDialogHasilTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                tambah(id);
            }
        });
        btnDialogHasilBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
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
