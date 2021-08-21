package com.mercadolibreprueba.mercadomobile.controller;

import com.mercadolibreprueba.mercadomobile.model.QueryResultModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebServiceClient {

    @GET("search")
    Call<QueryResultModel> getProductsComputacion(@Query("category") String category, @Query("limit") String limit);

    @GET("search?category=MCO1051&limit=10")
    Call<QueryResultModel> getProductsCelulares();

    @GET("search?category=MCO1276&limit=10")
    Call<QueryResultModel> getProductsDeportes();
}
