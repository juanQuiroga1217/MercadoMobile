package com.mercadolibreprueba.mercadomobile.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mercadolibreprueba.mercadomobile.R;
import com.mercadolibreprueba.mercadomobile.controller.CardProductAdapter;
import com.mercadolibreprueba.mercadomobile.controller.MessagesApp;
import com.mercadolibreprueba.mercadomobile.controller.SearchApiController;
import com.mercadolibreprueba.mercadomobile.controller.Utilities;
import com.mercadolibreprueba.mercadomobile.model.ConstantsApp;
import com.mercadolibreprueba.mercadomobile.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

import okhttp3.internal.Util;
import retrofit2.Retrofit;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView recyclerViewComputacion;
    private RecyclerView recyclerViewCelulares;
    private RecyclerView recyclerViewDeportes;

    private CardProductAdapter cardProductsComputacionAdapter;
    private CardProductAdapter cardProductCelularesAdapter;
    private CardProductAdapter cardProductAdapterDeportes;

    private Utilities utilities;
    private SearchApiController searchApiController;

    private ImageButton mBtnSearch;
    private EditText mTxtSearchBar;
    private ProgressBar mProgressBarComputacion;
    private ProgressBar mProgressBarCelulares;
    private ProgressBar mProgressBarDeportes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setUpView();
        setUpCategoryLists();
        loadControls();
    }



    private void setUpView() {

        mBtnSearch = findViewById(R.id.btnSearch);
        mTxtSearchBar = findViewById(R.id.txtSearch);

        recyclerViewComputacion = findViewById(R.id.recyclerCategoryComputacion);
        recyclerViewCelulares = findViewById(R.id.recyclerCategoryCelulares);
        recyclerViewDeportes = findViewById(R.id.recyclerCategoryDeportes);

        mProgressBarCelulares = findViewById(R.id.progressBarCategoryCelulares);
        mProgressBarComputacion = findViewById(R.id.progressBarCategoryComputacion);
        mProgressBarDeportes = findViewById(R.id.progressBarCategoryDeportes);

        mBtnSearch.setOnClickListener(view -> buscarProducto());

    }


    private void setUpCategoryLists() {

        searchApiController = new SearchApiController();
        utilities = new Utilities();

        LinearLayoutManager computacionLayoutManager = new LinearLayoutManager(this);
        utilities.setUpCardRecyclerView(recyclerViewComputacion, computacionLayoutManager);
        ArrayList<ProductModel> productsComputacion = new ArrayList<>();
        cardProductsComputacionAdapter = new CardProductAdapter(this, productsComputacion);

        LinearLayoutManager celularesLayoutManager = new LinearLayoutManager(this);
        utilities.setUpCardRecyclerView(recyclerViewCelulares, celularesLayoutManager);
        ArrayList<ProductModel> productsCelulares = new ArrayList<>();
        cardProductCelularesAdapter = new CardProductAdapter(this, productsCelulares);

        LinearLayoutManager deportesLayoutManager = new LinearLayoutManager(this);
        utilities.setUpCardRecyclerView(recyclerViewDeportes, deportesLayoutManager);
        ArrayList<ProductModel> productsDeportes = new ArrayList<>();
        cardProductAdapterDeportes = new CardProductAdapter(this, productsDeportes);

    }


    private void loadControls() {

        if (utilities.checkInternetConnection(this)){
            searchApiController.getByCategory(cardProductsComputacionAdapter, recyclerViewComputacion, ConstantsApp.getCategoryComputacionCode(), mProgressBarComputacion);
            searchApiController.getByCategory(cardProductCelularesAdapter, recyclerViewCelulares, ConstantsApp.getCategoryCelularesCode(), mProgressBarCelulares);
            searchApiController.getByCategory(cardProductAdapterDeportes, recyclerViewDeportes, ConstantsApp.getCategoryDeportesCode(), mProgressBarDeportes);

        } else {
            MessagesApp.showAlertMessage(getString(R.string.msg_network_error), getString(R.string.btnTxtOk), this);
        }
    }

    private void buscarProducto() {

        mBtnSearch.setClickable(false);
        searchApiController.getProductQueryResults(mTxtSearchBar.getText().toString());
        Intent intentProductList = new Intent(this, ProductListActivity.class);
        intentProductList.putExtra("SearchQuery", mTxtSearchBar.getText().toString());
        startActivity(intentProductList);

    }

}
