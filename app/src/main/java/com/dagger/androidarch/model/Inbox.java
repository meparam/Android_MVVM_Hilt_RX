package com.dagger.androidarch.model;

import android.content.res.TypedArray;
import android.graphics.Color;

import androidx.databinding.BaseObservable;

import com.dagger.androidarch.AppController;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Inbox  extends BaseObservable {


    @Override
    public String toString() {
        return "Inbox{" +
                "id=" + id +
                ", isImportant=" + isImportant +
                ", picture='" + picture + '\'' +
                ", from='" + from + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", isRead=" + isRead +
                '}';
    }


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("isImportant")
    @Expose
    private Boolean isImportant;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("isRead")
    @Expose
    private Boolean isRead;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(Boolean isImportant) {
        this.isImportant = isImportant;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }


}