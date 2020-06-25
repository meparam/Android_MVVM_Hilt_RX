package com.dagger.androidarch.utils;

import android.content.res.TypedArray;
import android.graphics.Color;

import com.dagger.androidarch.AppController;

public class Constants {
    public static String BaseURL="https://api.androidhive.info/";



    public static int getRandomMaterialColor() {
        int returnColor = Color.GRAY;
        String typeColor="400";

        int arrayId = AppController.getAppContext().getResources().
                getIdentifier("mdcolor_" + typeColor, "array", AppController.getAppContext().getPackageName());

        if (arrayId != 0) {
            TypedArray colors = AppController.getAppContext().getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.GRAY);
            colors.recycle();
        }
        return returnColor;
    }
}
