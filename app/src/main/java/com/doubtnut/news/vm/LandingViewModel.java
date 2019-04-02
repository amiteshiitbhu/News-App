package com.doubtnut.news.vm;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.doubtnut.news.adapter.NewsAdapter;
import com.doubtnut.news.model.NewsResponse;
import com.doubtnut.news.retro.RepoService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LandingViewModel extends ViewModel {

    private RepoService repoService;
    //TODO commented due to problem with androidx
//    private NewsDao newsDao;
    private CompositeDisposable compositeDisposable;

    public ObservableBoolean isLoading = new ObservableBoolean(true);
    public ObservableField<String> errorMessage = new ObservableField<String>();

    public ObservableField<NewsAdapter> articles = new ObservableField<>();

    @Inject
    public LandingViewModel(RepoService repoService/*, NewsDao newsDao*/) {
        this.repoService = repoService;
//        this.newsDao = newsDao;
        this.compositeDisposable = new CompositeDisposable();
        fetchData();
    }

    private void fetchData() {
        Disposable disposable = repoService.getTopHeadlines("us", "83e250c93bb64c9f9f98a02a1502ff16")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onNewsFetch, this::onError);
        compositeDisposable.add(disposable);
    }

    private void onNewsFetch(NewsResponse newsResponse) {
        isLoading.set(false);
        if (newsResponse == null || newsResponse.getArticles() == null || newsResponse.getArticles().size() == 0) {
            errorMessage.set("No News Found");
            return;
        }
        errorMessage.set(null);
        this.articles.set(new NewsAdapter(newsResponse.getArticles()));
    }

    private void onError(Throwable throwable) {
        errorMessage.set(throwable.getMessage());
    }


    @Override
    protected void onCleared() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
        super.onCleared();
    }
}
