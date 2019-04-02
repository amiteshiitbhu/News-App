package com.doubtnut.news.model;

import java.util.List;

public class NewsResponse {

    private String totalResults;
    private List<Articles> articles;
    private String status;

    public String getTotalResults() {
        return totalResults;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public String getStatus() {
        return status;
    }
}
