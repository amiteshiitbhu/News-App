package com.doubtnut.news;

import android.app.Application;
import android.content.Context;

import com.doubtnut.news.di.DaggerNewsComponent;
import com.doubtnut.news.di.NewsComponent;
import com.doubtnut.news.di.module.NewsModule;

public class NewsApplication extends Application {

    private NewsComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerNewsComponent.builder()
                .newsModule(new NewsModule())
                .build();
        component.inject(this);
    }

    public NewsComponent getComponent() {
        return component;
    }


    public static NewsApplication get(Context context) {
        return (NewsApplication) context.getApplicationContext();
    }
}
