package com.mercadolibreprueba.mercadomobile.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class QuerySellerResultModel {

    @SerializedName("seller")
    private SellerModel resultSeller;

    public SellerModel getResultSeller() {
        return resultSeller;
    }

    public void setResultSeller(SellerModel resultSeller) {
        this.resultSeller = resultSeller;
    }
}
