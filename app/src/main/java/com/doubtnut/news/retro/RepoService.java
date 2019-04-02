package com.doubtnut.news.retro;

import com.doubtnut.news.model.NewsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RepoService {

    @GET("/v2/top-headlines")
    Observable<NewsResponse> getTopHeadlines(@Query("country") String country,
                                                   @Query("apiKey") String apiKey);

}
