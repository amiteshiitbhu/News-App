package com.doubtnut.news.di.module;

import android.arch.lifecycle.ViewModelProvider;

import com.doubtnut.news.di.ViewModelSubComponent;
import com.doubtnut.news.retro.RepoService;
import com.doubtnut.news.vm.ViewModelProviderFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//import com.doubtnut.news.room.NewsDao;
//import com.doubtnut.news.room.NewsDatabase;
//import androidx.room.Room;

@Module (subcomponents = ViewModelSubComponent.class)
public class NewsModule {

    private static final String BASE_URL = "https://newsapi.org";

    @Singleton
    @Provides
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static RepoService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(RepoService.class);
    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {

        return new ViewModelProviderFactory(viewModelSubComponent.build());
    }
//TODO commented due to problem with androidx
//    @Singleton
//    @Provides
//    public NewsDatabase provideNewsDatabase(Context context) {
//        return Room.databaseBuilder(context,
//                NewsDatabase.class, NewsDatabase.DATABASE_NAME)
//                .fallbackToDestructiveMigration()
//                .allowMainThreadQueries()
//                .build();
//    }
//
//    @Singleton
//    @Provides
//    public NewsDao provideShowDao(NewsDatabase newsDatabase) {
//        return newsDatabase.newsDao();
//    }



}
