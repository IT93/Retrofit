package com.journaldev.retrofitintro;

import com.google.gson.annotations.SerializedName;

/**
 * Created by WeltesDev on 12/20/2017.
 */

public class Model {

    private String headmark;


    public Model(String headmark) {
        this.headmark = headmark;
    }

    @SerializedName("head")
    String getHeadmark() {
        return headmark;
    }
}