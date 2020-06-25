package com.dagger.androidarch.di;


import com.dagger.androidarch.utils.Constants;
import com.dagger.androidarch.network.MovieApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by paramvir Singh on 22,June,2020
 */

//second  step

@Module
@InstallIn(ApplicationComponent.class)
public class NetworkModule {
    @Provides
    @Singleton
    public static MovieApiService provideMovieApiService(){
        return  new Retrofit.Builder()
                .baseUrl(Constants.BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(MovieApiService.class);
    }

}
