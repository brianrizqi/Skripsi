package id.onestep.skripsi.Adapter;

import android.app.Activity;
import android.content.Intent;
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

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Models.Lahan.Lahan;
import id.onestep.skripsi.R;
import id.onestep.skripsi.Activities.Tanaman;
import id.onestep.skripsi.Response.DefaultResponse;
import id.onestep.skripsi.Response.LahanEditResponse;
import id.onestep.skripsi.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        holder.itemView.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.fade));
        String[] array = activity.getResources().getStringArray(R.array.color);
        String randomStr = array[new Random().nextInt(array.length)];
        holder.side.setBackgroundColor(Color.parseColor(randomStr));
        holder.txtItemLahanJudul.setText("Lahan " + (position + 1));
        holder.txtItemLahanLuas.setText(post.getLarge() + " HA");
        if (post.getPlantings().size() != 0) {
            holder.txtItemLahanTanaman.setText("Tanaman " + post.getPlantings().get(0).getPlant().getName());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, Tanaman.class);
                i.putExtra("area_id", post.getId());
                i.putExtra("lahan", position + 1);
                activity.startActivity(i);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                dialogButton(post.getId());
                return true;
            }
        });
    }

    private void dialogButton(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View view = LayoutInflater.from(activity).inflate(R.layout.dialog_lahan, null);
        RelativeLayout btnUpdateLahan = (RelativeLayout) view.findViewById(R.id.btnUpdateLahan);
        TextInputEditText etLarge = (TextInputEditText) view.findViewById(R.id.etLarge);
        getData(etLarge, id);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
        btnUpdateLahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateLahan(dialog, id, etLarge);
            }
        });
    }

    private void getData(TextInputEditText etLarge, int id) {
        Call<LahanEditResponse> call = Service
                .getInstance()
                .getAPI()
                .getLahanId(
                        id
                );
        call.enqueue(new Callback<LahanEditResponse>() {
            @Override
            public void onResponse(Call<LahanEditResponse> call, Response<LahanEditResponse> response) {
                if (response.body().isError()) {
                    Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    etLarge.setText("" + response.body().getData().getLarge());
                }
            }

            @Override
            public void onFailure(Call<LahanEditResponse> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateLahan(AlertDialog dialog, int id, TextInputEditText etLarge) {
        String large = etLarge.getText().toString().trim();
        Call<DefaultResponse> call = Service
                .getInstance()
                .getAPI()
                .updateLahan(
                        id,
                        Integer.parseInt(large)
                );
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.body().isError()) {
                    Toast.makeText(activity, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(activity, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
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
