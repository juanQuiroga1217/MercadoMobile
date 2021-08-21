package com.mercadolibreprueba.mercadomobile.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class QueryResultModel {

    @SerializedName("site_id")
    private String resultSiteId;

    @SerializedName("country_default_time_zone")
    private String resultTimeZone;

    @SerializedName("results")
    private ArrayList<ProductModel> resultProductList;

    public String getResultSiteId() {
        return resultSiteId;
    }

    public void setResultSiteId(String resultSiteId) {
        this.resultSiteId = resultSiteId;
    }

    public String getResultTimeZone() {
        return resultTimeZone;
    }

    public void setResultTimeZone(String resultTimeZone) {
        this.resultTimeZone = resultTimeZone;
    }

    public ArrayList<ProductModel> getResultProductList() {
        return resultProductList;
    }

    public void setResultProductList(ArrayList<ProductModel> resultProductList) {
        this.resultProductList = resultProductList;
    }
}
