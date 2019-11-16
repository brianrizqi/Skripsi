package id.onestep.skripsi.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Activities.DetailArticle;
import id.onestep.skripsi.Models.Article;
import id.onestep.skripsi.R;

import static id.onestep.skripsi.Service.Service.BASE_URL_STORAGE;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private Activity activity;
    private List<Article> list;

    public ArticleAdapter(Activity activity, List<Article> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(activity).inflate(R.layout.item_dashboard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Article post = list.get(position);
        holder.txtArticleDate.setText(post.getCreatedAt());
        holder.txtArticleTitle.setText(post.getTitle());
        Glide.with(activity)
                .load(BASE_URL_STORAGE + post.getImg())
                .into(holder.imgArticle);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, DetailArticle.class);
                i.putExtra("data", post);
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgArticle)
        ImageView imgArticle;
        @BindView(R.id.txtArticleTitle)
        TextView txtArticleTitle;
        @BindView(R.id.txtArticleDate)
        TextView txtArticleDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
