package id.onestep.skripsi.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Activities.TambahTanamanManual;
import id.onestep.skripsi.Activities.Tanaman;
import id.onestep.skripsi.Models.Result;
import id.onestep.skripsi.R;
import id.onestep.skripsi.Response.DefaultResponse;
import id.onestep.skripsi.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HasilAdapter extends RecyclerView.Adapter<HasilAdapter.ViewHolder> {
    private Context context;
    private List<Result> list;
    private int area_id, lahan;

    public HasilAdapter(Context context, List<Result> list, int area_id, int lahan) {
        this.context = context;
        this.list = list;
        this.area_id = area_id;
        this.lahan = lahan;
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
                tambah(id, area_id);
            }
        });
        btnDialogHasilBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void tambah(int id, int area_id) {
        Call<DefaultResponse> call = Service
                .getInstance()
                .getAPI()
                .addTanamanManual(
                        area_id,
                        id
                );
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.body().isError()) {
                    Toast.makeText(context, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(context, Tanaman.class);
                    i.putExtra("area_id", area_id);
                    i.putExtra("lahan", lahan);
                    context.startActivity(i);
                    ((Activity) context).finish();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
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
