package com.dagger.androidarch.repository;
import androidx.lifecycle.LiveData;

import com.dagger.androidarch.model.Inbox;
import com.dagger.androidarch.network.MovieApiService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by Paramvir Singh on 10,June,2020
 */

public class Repository {
    private static final String TAG = "Repository";

    MovieApiService apiService;

    @Inject
    public Repository(MovieApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<JsonArray> getAllMail(){
        return  apiService.getAllMail();
    }

    public Observable<JsonArray> getAllMunu(){
        return  apiService.getAllMenu();
    }

    public Observable<JsonObject> getAllFeed(){
        return  apiService.getAllFeed();
    }


//    public Observable<.......>  getCurrentlyShowing(HashMap<String, String> map){
//        return apiService.getCurrentlyShowing(map);
//    }


}
