package com.dagger.androidarch.network;

import com.dagger.androidarch.model.Inbox;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Paramvir Singh on 22,June,2020
 */
public interface MovieApiService {

    @GET("json/inbox.json")
    Observable<JsonArray> getAllMail();

    @GET("json/menu.json")
    Observable<JsonArray> getAllMenu();

    @GET("feed/feed.json")
    Observable<JsonObject> getAllFeed();


//    @GET("movie/popular")
//    Observable<MovieResponse> getPopular(@QueryMap HashMap<String,String> queries);
//
//    @GET("movie/upcoming")
//    Observable<MovieResponse> getUpcoming(@QueryMap HashMap<String,String> queries);
//
//    @GET("movie/top_rated")
//    Observable<MovieResponse> getTopRated(@QueryMap HashMap<String,String> queries);
//
//    @GET("movie/{movie_id}")
//    Observable<Movie> getMovieDetails(@Path ("movie_id") int id, @QueryMap HashMap<String,String> queries);
//
//    @GET("movie/{movie_id}/credits")
//    Observable<JsonObject> getCast(@Path ("movie_id") int id, @QueryMap HashMap<String,String> queries);
//
//    @GET("person/{person_id}")
//    Observable<Actor> getActorDetails(@Path ("person_id") int id, @QueryMap HashMap<String, String> queries);
//
//    @GET("person/{person_id}/images")
//    Observable<JsonObject> getActorImages(@Path ("person_id") int id, @Query("api_key") String api);
//
//    @GET("search/movie")
//    Observable<JsonObject> getMoviesBySearch(@QueryMap HashMap<String,String> queries);





}
