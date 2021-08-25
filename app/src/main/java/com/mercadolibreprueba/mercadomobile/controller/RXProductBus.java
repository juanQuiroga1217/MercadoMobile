package com.mercadolibreprueba.mercadomobile.controller;

import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.RecyclerView;

import com.mercadolibreprueba.mercadomobile.model.ProductModel;

import java.util.ArrayList;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class RXProductBus {

        private static final BehaviorSubject<ArrayList<ProductModel>> behaviourSubject
                = BehaviorSubject.create();

        static BehaviorSubject<ArrayList<ProductModel>> getBehaviourSubject() {
            return behaviourSubject;
        }

        public static Disposable loadSearchList(ProductListAdapter productListAdapter, RecyclerView recyclerView, ProgressBar progressBar){

            return RXProductBus.getBehaviourSubject().
                    subscribeWith(new DisposableObserver<ArrayList<ProductModel>>() {

                        @Override
                        public void onNext(@NonNull ArrayList<ProductModel> queryProductResultModel) {
                            if (queryProductResultModel != null) {
                                productListAdapter.setProducts(queryProductResultModel);
                                recyclerView.setAdapter(productListAdapter);
                                recyclerView.setVisibility(View.VISIBLE);
                                progressBar.setVisibility(View.GONE);

                            }
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            MessagesApp.LogApiException(getClass(), e.getMessage());
                        }

                        @Override
                        public void onComplete() {
                            MessagesApp.logMessage("Search Query Complete: " + this.getClass());
                        }
                    });
        }


}
