package com.mercadolibreprueba.mercadomobile.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mercadolibreprueba.mercadomobile.R;
import com.mercadolibreprueba.mercadomobile.controller.CardProductAdapter;
import com.mercadolibreprueba.mercadomobile.controller.MessagesApp;
import com.mercadolibreprueba.mercadomobile.controller.ProductListAdapter;
import com.mercadolibreprueba.mercadomobile.controller.RXProductBus;
import com.mercadolibreprueba.mercadomobile.controller.Utilities;
import com.mercadolibreprueba.mercadomobile.model.ConstantsApp;
import com.mercadolibreprueba.mercadomobile.model.ProductModel;
import com.mercadolibreprueba.mercadomobile.model.QueryProductResultModel;

import java.util.ArrayList;
import java.util.Objects;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import okhttp3.internal.Util;

public class ProductListActivity extends AppCompatActivity {


    private EditText mTxtSearchBar;
    private TextView mTxtResultadosBusqueda;
    private ImageButton mBtnSearch;

    private RecyclerView mRecyclerSearchResult;

    private ProductListAdapter productListAdapter;

    private Utilities utilities;
    private Disposable disposable;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        setupView();
        loadControls();
    }

    private void setupView() {

        utilities = new Utilities();

        mTxtSearchBar = findViewById(R.id.txtSearchList);
        mTxtResultadosBusqueda = findViewById(R.id.lblResultadosBusqueda);
        mBtnSearch = findViewById(R.id.btnSearchList);




        mRecyclerSearchResult = findViewById(R.id.recyclerSearchResult);
        LinearLayoutManager productLayoutManager = new LinearLayoutManager(this);
        utilities.setUpRecyclerView(mRecyclerSearchResult, productLayoutManager);
        ArrayList<ProductModel> products = new ArrayList<>();
        productListAdapter = new ProductListAdapter(this, products);
    }


    private void loadControls() {


        String strBusqueda = getString(R.string.lblResultados) + Objects.requireNonNull(getIntent().getExtras()).getString("SearchQuery");

        mTxtResultadosBusqueda.setText(strBusqueda);

        disposable = RXProductBus.getBehaviourSubject().
                subscribeWith(new DisposableObserver<ArrayList<ProductModel>>(){

                    @Override
                    public void onNext(@NonNull ArrayList<ProductModel> queryProductResultModel) {
                        if (queryProductResultModel != null){
                            productListAdapter.setProducts(queryProductResultModel);
                            mRecyclerSearchResult.setAdapter(productListAdapter);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        MessagesApp.LogApiException(getClass(), e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        MessagesApp.logMessage("Search Query Complete: "+ getLocalClassName());
                    }
                });
    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
        disposable.dispose();
    }
}
