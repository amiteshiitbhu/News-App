package com.doubtnut.news.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Articles implements Parcelable {
    private String publishedAt;
    private String author;
    private String urlToImage;
    private String description;
    private Source source;
    private String title;
    private String url;
    private String content;

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getDescription() {
        return description;
    }

    public Source getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.publishedAt);
        dest.writeString(this.author);
        dest.writeString(this.urlToImage);
        dest.writeString(this.description);
        dest.writeParcelable(this.source, flags);
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeString(this.content);
    }

    public Articles() {
    }

    protected Articles(Parcel in) {
        this.publishedAt = in.readString();
        this.author = in.readString();
        this.urlToImage = in.readString();
        this.description = in.readString();
        this.source = in.readParcelable(Source.class.getClassLoader());
        this.title = in.readString();
        this.url = in.readString();
        this.content = in.readString();
    }

    public static final Parcelable.Creator<Articles> CREATOR = new Parcelable.Creator<Articles>() {
        @Override
        public Articles createFromParcel(Parcel source) {
            return new Articles(source);
        }

        @Override
        public Articles[] newArray(int size) {
            return new Articles[size];
        }
    };
}

