package id.onestep.skripsi.Adapter;

import android.content.Context;
import android.graphics.Color;
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

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Models.Tanaman.DataItem;
import id.onestep.skripsi.R;
import id.onestep.skripsi.Response.DefaultResponse;
import id.onestep.skripsi.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        holder.itemView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade));
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (post.getStatus() == 0) {
                    dialog(post.getId());
                } else {
                    Toast.makeText(context, "Tanaman sudah panen", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void dialog(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_verifikasi_tanaman, null);
        RelativeLayout btnVerifTanaman = (RelativeLayout) view.findViewById(R.id.btnVerifTanaman);
        TextInputEditText etPemasukan = (TextInputEditText) view.findViewById(R.id.etPemasukan);
        TextInputEditText etPengeluaran = (TextInputEditText) view.findViewById(R.id.etPengeluaran);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
        btnVerifTanaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verif(id, etPemasukan, etPengeluaran, dialog);
            }
        });
    }

    private void verif(int id, TextInputEditText etPemasukan, TextInputEditText etPengeluaran, AlertDialog dialog) {
        if (etPemasukan.getText().toString().isEmpty()) {
            etPemasukan.setError("Pemasukkan tidak boleh kosong");
            etPemasukan.requestFocus();
            return;
        }

        if (etPengeluaran.getText().toString().isEmpty()) {
            etPengeluaran.setError("Pengeluaran tidak boleh kosong");
            etPengeluaran.requestFocus();
            return;
        }
        int pemasukan = Integer.parseInt(etPemasukan.getText().toString());
        int pengeluaran = Integer.parseInt(etPengeluaran.getText().toString());
        Call<DefaultResponse> call = Service
                .getInstance()
                .getAPI()
                .verifTanaman(
                        id,
                        pemasukan,
                        pengeluaran
                );
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.body().isError()) {
                    Toast.makeText(context, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
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
