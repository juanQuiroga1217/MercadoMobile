package com.mercadolibreprueba.mercadomobile.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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

    private final Utilities utilities = new Utilities();

    private ImageButton mBtnSearch;
    private EditText mTxtSearchBar;


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

    }


    private void setUpCategoryLists() {

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

        SearchApiController searchApiController = new SearchApiController();

        if (utilities.checkInternetConnection(this)){
            searchApiController.getByCategory(cardProductsComputacionAdapter, recyclerViewComputacion, ConstantsApp.getCategoryComputacionCode());
            searchApiController.getByCategory(cardProductCelularesAdapter, recyclerViewCelulares, ConstantsApp.getCategoryCelularesCode());
            searchApiController.getByCategory(cardProductAdapterDeportes, recyclerViewDeportes, ConstantsApp.getCategoryDeportesCode());

        } else {
            MessagesApp.showAlertMessage(getString(R.string.msg_network_error), getString(R.string.btnTxtOk), this);
        }
    }
}
