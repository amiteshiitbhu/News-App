package com.doubtnut.news.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.doubtnut.news.R;
import com.doubtnut.news.model.Articles;
import com.squareup.picasso.Picasso;

//Need time to optimize this activity fetch data from database
public class DetailActivity extends AppCompatActivity {

    public static final String ITEM = "item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Articles articles = getIntent().getParcelableExtra(ITEM);

        getSupportActionBar().setTitle(articles.getTitle());

        ((TextView)findViewById(R.id.title)).setText(articles.getTitle());
        ((TextView)findViewById(R.id.description)).setText(articles.getDescription());
        ((TextView)findViewById(R.id.publishedAt)).setText(articles.getPublishedAt());
        ((TextView)findViewById(R.id.content)).setText(articles.getContent());
        Picasso.get().load(articles.getUrlToImage()).into((ImageView)findViewById(R.id.urlToImage));

        ((TextView)findViewById(R.id.url)).setText(articles.getUrl());
        ((TextView)findViewById(R.id.url)).setOnClickListener(view -> openUrl(articles.getUrl()));
    }

    private void openUrl(String url) {
        try {
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(myIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No application can handle this request."
                    + " Please install a webbrowser", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
