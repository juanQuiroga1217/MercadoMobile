package com.mercadolibreprueba.mercadomobile.controller;

import com.mercadolibreprueba.mercadomobile.model.QueryProductResultModel;
import com.mercadolibreprueba.mercadomobile.model.QuerySellerResultModel;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebServiceClient {

    @GET("search")
    Call<QueryProductResultModel> getProductsByCategory(@Query("category") String category, @Query("limit") String limit);

    @GET("search")
    Call<QuerySellerResultModel> getSellerInfo(@Query("seller_id") String sellerId);

    @GET("search")
    Call<QueryProductResultModel> getProductsBySearch(@Query("q") String searchValue);

}
