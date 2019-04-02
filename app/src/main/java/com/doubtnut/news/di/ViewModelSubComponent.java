package com.doubtnut.news.di;

import com.doubtnut.news.vm.LandingViewModel;

import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    LandingViewModel landingViewModel();
}