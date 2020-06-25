package com.dagger.androidarch.ui.notifications;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dagger.androidarch.model.Inbox;
import com.dagger.androidarch.repository.Repository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NotificationsViewModel extends ViewModel {

    private Repository repository;
    private MutableLiveData<ArrayList<Inbox>> allInboxList ;
    private final CompositeDisposable disposables = new CompositeDisposable();

    @ViewModelInject
    public NotificationsViewModel(Repository repository) {
        this.repository=repository;
    }

    public MutableLiveData<ArrayList<Inbox>> getAllInbox(){

        if(allInboxList==null){
            allInboxList = new MutableLiveData<>();
            getCast();
        }
        return allInboxList;
    }

    public void getCast() {
        disposables.add(repository.getAllMail()
                .subscribeOn(Schedulers.io())
                .map(new Function<JsonArray, ArrayList<Inbox>>() {
                    @Override
                    public ArrayList<Inbox> apply(JsonArray jsonArray) throws Throwable {
                      //  JsonArray jsonArray = jsonObject.getAsJsonArray("cast");
                        Log.e("TAG", "apply: " );
                        return  new Gson().fromJson(jsonArray.toString(), new TypeToken<ArrayList<Inbox>>(){}.getType());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> allInboxList.setValue(result),
                        error -> Log.e("Inbox", "getCastList: " + error.getMessage()))
        );
    }

//    public void getCastDuplicate() {
//        disposables.add(repository.getAllMail()
//                .subscribeOn(Schedulers.io())
//                .map((Function<JsonArray, ArrayList<Inbox>>) jsonArray -> {
//                    return  new Gson().fromJson(jsonArray.toString(), new TypeToken<ArrayList<Inbox>>(){}.getType());
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(result -> allInboxList.setValue(result),
//                        error -> Log.e("Inbox", "getCastList: " + error.getMessage()))
//        );
//    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}