package com.mercadolibreprueba.mercadomobile.controller;

import androidx.recyclerview.widget.RecyclerView;

import com.mercadolibreprueba.mercadomobile.model.ConstantsApp;
import com.mercadolibreprueba.mercadomobile.model.ProductModel;
import com.mercadolibreprueba.mercadomobile.model.QueryResultModel;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchApiController {

    private WebServiceClient webServiceClient;

    public SearchApiController(){
        setUpRetrofit();
    }

    private void setUpRetrofit() {

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsApp.getURL())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        webServiceClient = retrofit.create(WebServiceClient.class);

    }


    public void getByCategory(CardProductAdapter cardAdapter, RecyclerView CardRecyclerView, String category){

        Call<QueryResultModel> callComputacion = webServiceClient.getProductsComputacion(category, ConstantsApp.getCategoryListLimit());
        callComputacion.enqueue(new Callback<QueryResultModel>() {
            @Override
            public void onResponse(Call<QueryResultModel> call, Response<QueryResultModel> response) {
                cardAdapter.setProducts(response.body().getResultProductList());
                CardRecyclerView.setAdapter(cardAdapter);
            }

            @Override
            public void onFailure(Call<QueryResultModel> call, Throwable t) {
                MessagesApp.LogApiException(getClass(), t.getMessage());
            }
        });

    }




}
