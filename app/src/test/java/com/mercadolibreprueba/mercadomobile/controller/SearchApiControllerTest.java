package com.mercadolibreprueba.mercadomobile.controller;

import com.mercadolibreprueba.mercadomobile.model.ConstantsApp;
import com.mercadolibreprueba.mercadomobile.model.QueryProductResultModel;
import com.mercadolibreprueba.mercadomobile.model.QuerySellerResultModel;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;

public class SearchApiControllerTest {

    private WebServiceClient webServiceClient;
    @Before
    public void initRetrofit() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsApp.getURL())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        webServiceClient = retrofit.create(WebServiceClient.class);
    }

    @Test
    public void testApiResponseByCategory() {

        Call<QueryProductResultModel> callCategory = webServiceClient.getProductsByCategory(ConstantsApp.getCategoryComputacionCode(), ConstantsApp.getCategoryListLimit());

        try {
            Response response = callCategory.execute();
            assertTrue(response.isSuccessful() &&response.body()!=null);
        } catch (IOException e){
            MessagesApp.LogMessageException(this.getClass(), e);
        }

    }

    @Test
    public void testApiResponseBySeller() {

        Call<QuerySellerResultModel> callSeller = webServiceClient.getSellerInfo("530380977");

        try {
            Response response = callSeller.execute();
            assertTrue(response.isSuccessful() &&response.body()!=null);
        } catch (IOException e){
            MessagesApp.LogMessageException(this.getClass(), e);
        }

    }

    @Test
    public void testApiResponseByQuery() {

        Call<QueryProductResultModel> callProduct = webServiceClient.getProductsBySearch("Celulares");

        try {
            Response response = callProduct.execute();
            assertTrue(response.isSuccessful() && response.body()!= null);
        } catch (IOException e){
            MessagesApp.LogMessageException(this.getClass(), e);
        }
    }

}