package com.doubtnut.news.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.doubtnut.news.R;
import com.doubtnut.news.activity.DetailActivity;
import com.doubtnut.news.model.Articles;
import com.squareup.picasso.Picasso;

import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private final List<Articles> articles;

    public NewsAdapter(List<Articles> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new NewsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder viewHolder, int position) {
        viewHolder.bindData(articles.get(position));

    }

    @Override
    public int getItemCount() {
        return articles == null ? 0 : articles.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        private OnNewsClickListener listener;
        public TextView title;
        public TextView description;
        public ImageView urlToImage;
        public TextView publishedAt;
        public TextView content;

        public NewsViewHolder(View v/*, OnNewsClickListener listener*/) {
            super(v);
            itemView.setOnClickListener(this);
//            this.listener = listener;
            title = v.findViewById(R.id.title);
            description = v.findViewById(R.id.description);
            urlToImage = v.findViewById(R.id.urlToImage);
            publishedAt = v.findViewById(R.id.publishedAt);
//            content = v.findViewById(R.id.content);
        }

        public void bindData(Articles articles) {
            itemView.setTag(articles);
            title.setText(articles.getTitle());
            description.setText(articles.getDescription());
            Picasso.get().load(articles.getUrlToImage()).into(urlToImage);
            publishedAt.setText(articles.getPublishedAt());
//            content.setText(articles.getContent());
        }

        @Override
        public void onClick(View view) {
            //TODO make call back to viewmodel temp fix
//            if (listener != null) {
//                listener.onClick((Articles) view.getTag());
//            }
            Context context = view.getContext();
            Articles tag = (Articles) view.getTag();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(DetailActivity.ITEM, tag);
            context.startActivity(intent);
        }
    }

    interface OnNewsClickListener {
        void onClick(Articles articles);
    }
}