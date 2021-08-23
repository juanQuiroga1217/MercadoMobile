package com.mercadolibreprueba.mercadomobile.controller;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mercadolibreprueba.mercadomobile.model.ConstantsApp;
import com.mercadolibreprueba.mercadomobile.model.ProductModel;
import com.mercadolibreprueba.mercadomobile.model.QueryProductResultModel;
import com.mercadolibreprueba.mercadomobile.model.QuerySellerResultModel;
import com.mercadolibreprueba.mercadomobile.model.SellerModel;

import io.reactivex.rxjava3.subjects.BehaviorSubject;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
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
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        webServiceClient = retrofit.create(WebServiceClient.class);

    }

    public void getProductQueryResults(String query){

        Call<QueryProductResultModel> callQueryResults = webServiceClient.getProductsBySearch(query);
        callQueryResults.enqueue(new Callback<QueryProductResultModel>() {
            @Override
            public void onResponse(Call<QueryProductResultModel> call, Response<QueryProductResultModel> response) {
                assert response.body() != null;

                RXProductBus.getBehaviourSubject().onNext(response.body().getResultProductList());
            }

            @Override
            public void onFailure(Call<QueryProductResultModel> call, Throwable t) {
                MessagesApp.LogApiException(getClass(), t.getMessage());
            }
        });
    }

    public void getByCategory(CardProductAdapter cardAdapter, RecyclerView CardRecyclerView, String category, ProgressBar progressBar){

        Call<QueryProductResultModel> callCategory = webServiceClient.getProductsByCategory(category, ConstantsApp.getCategoryListLimit());
        callCategory.enqueue(new Callback<QueryProductResultModel>() {
            @Override
            public void onResponse(Call<QueryProductResultModel> call, Response<QueryProductResultModel> response) {
                assert response.body() != null;
                cardAdapter.setProducts(response.body().getResultProductList());
                CardRecyclerView.setAdapter(cardAdapter);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<QueryProductResultModel> call, Throwable t) {
                MessagesApp.LogApiException(getClass(), t.getMessage());
            }
        });

    }

    public void getSellerData(String sellerId, TextView textSeller){

        Call<QuerySellerResultModel> callSeller = webServiceClient.getSellerInfo(sellerId);
        callSeller.enqueue(new Callback<QuerySellerResultModel>() {
            @Override
            public void onResponse(Call<QuerySellerResultModel> call, Response<QuerySellerResultModel> response) {
                assert response.body() != null;
                SellerModel sellerResult = response.body().getResultSeller();
                textSeller.setText(sellerResult.getSellerNickname());
            }

            @Override
            public void onFailure(Call<QuerySellerResultModel> call, Throwable t) {

            }
        });
    }



}
