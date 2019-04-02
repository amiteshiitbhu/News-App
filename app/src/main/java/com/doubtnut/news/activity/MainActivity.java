package com.doubtnut.news.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.doubtnut.news.NewsApplication;
import com.doubtnut.news.R;
import com.doubtnut.news.databinding.ActivityMainBinding;
import com.doubtnut.news.retro.RepoService;
import com.doubtnut.news.vm.LandingViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory factory;
    @Inject
    RepoService repoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NewsApplication.get(this).getComponent().inject(this);
        LandingViewModel viewModel = ViewModelProviders.of(this, factory).get(LandingViewModel.class);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);
    }
}
