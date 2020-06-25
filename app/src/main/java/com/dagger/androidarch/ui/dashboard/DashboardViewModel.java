package com.dagger.androidarch.ui.dashboard;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dagger.androidarch.model.Feed;
import com.dagger.androidarch.model.MenuModel;
import com.dagger.androidarch.repository.Repository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DashboardViewModel extends ViewModel {

    private Repository repository;
    private MutableLiveData<ArrayList<Feed>> allFeedList ;
    private final CompositeDisposable disposables = new CompositeDisposable();


    @ViewModelInject
    public DashboardViewModel(Repository repository) {
        this.repository=repository;
    }

    public MutableLiveData<ArrayList<Feed>> getAllFeed(){

        if(allFeedList==null){
            allFeedList = new MutableLiveData<>();
            getFeed();
        }
        return allFeedList;
    }

    private void getFeed() {
        disposables.add(repository.getAllFeed()
                .subscribeOn(Schedulers.io())
                .map(new Function<JsonObject, ArrayList<Feed>>() {
                    @Override
                    public ArrayList<Feed> apply(JsonObject jsonObject) throws Throwable {
                          JsonArray jsonArray = jsonObject.getAsJsonArray("feed");
                        Log.e("TAG", "apply: " );
                        return  new Gson().fromJson(jsonArray.toString(), new TypeToken<ArrayList<Feed>>(){}.getType());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> allFeedList.setValue(result),
                        error -> Log.e("Inbox", "getCastList: " + error.getMessage()))
        );


    }

}