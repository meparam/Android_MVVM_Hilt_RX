package com.dagger.androidarch.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feed extends BaseObservable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("profilePic")
    @Expose
    private String profilePic;
    @SerializedName("timeStamp")
    @Expose
    private String timeStamp;
    @SerializedName("url")
    @Expose
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @BindingAdapter({"profilePic"})
    public static void loadprofilePic(ImageView view, String url) {
        Glide.with(view.getContext()).load(url)
                .into(view);
    }
    @BindingAdapter({"image"})
    public static void loadfeedimage(ImageView view, String url) {

        Glide.with(view.getContext())
                .load(url)
               // .override(Target.SIZE_ORIGINAL, 500) // resizes width to 100
                .into(view);
    }

}