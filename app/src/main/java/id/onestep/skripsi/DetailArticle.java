package id.onestep.skripsi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.onestep.skripsi.Models.Article;

import static id.onestep.skripsi.Service.Service.BASE_URL_STORAGE;

public class DetailArticle extends AppCompatActivity {
    @BindView(R.id.imgArticle)
    ImageView imgArticle;
    @BindView(R.id.txtArticleTitle)
    TextView txtArticleTitle;
    @BindView(R.id.txtArticleDate)
    TextView txtArticleDate;
    @BindView(R.id.txtArticle)
    TextView txtArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_article);
        ButterKnife.bind(this);
        Article data = (Article) getIntent().getSerializableExtra("data");
        txtArticle.setText(data.getArticle());
        txtArticleDate.setText(data.getCreatedAt());
        txtArticleTitle.setText(data.getTitle());
        Glide.with(this)
                .load(BASE_URL_STORAGE + data.getImg())
                .into(imgArticle);
    }
}
