package com.doubtnut.news.di;

import com.doubtnut.news.NewsApplication;
import com.doubtnut.news.activity.MainActivity;
import com.doubtnut.news.di.module.NewsModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = NewsModule.class)
public interface NewsComponent {

    void inject(NewsApplication application);

    void inject(MainActivity application);
}
