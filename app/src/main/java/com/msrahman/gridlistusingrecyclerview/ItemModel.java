package com.msrahman.gridlistusingrecyclerview;

import android.app.Activity;

/**
 * Created by pg3 on 9/21/2017.
 */

public class ItemModel {

    private int id;
    private int imgResource;
    private String name;
    private Activity activity;

    public ItemModel(int id, int imgResource, String name, Activity activity) {
        this.id = id;
        this.imgResource = imgResource;
        this.name = name;
        this.activity = activity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
