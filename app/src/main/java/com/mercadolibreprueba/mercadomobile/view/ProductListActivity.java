package com.mercadolibreprueba.mercadomobile.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mercadolibreprueba.mercadomobile.R;
import com.mercadolibreprueba.mercadomobile.controller.ProductListAdapter;
import com.mercadolibreprueba.mercadomobile.controller.RXProductBus;
import com.mercadolibreprueba.mercadomobile.controller.SearchApiController;
import com.mercadolibreprueba.mercadomobile.controller.Utilities;
import com.mercadolibreprueba.mercadomobile.model.ProductModel;

import java.util.ArrayList;
import java.util.Objects;

import io.reactivex.rxjava3.disposables.Disposable;

public class ProductListActivity extends AppCompatActivity {


    private EditText mTxtSearchBar;
    private TextView mTxtResultadosBusqueda;
    private ImageButton mBtnSearch;
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerSearchResult;

    private ProductListAdapter productListAdapter;

    private Utilities utilities;
    private SearchApiController searchApiController;
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
        mProgressBar = findViewById(R.id.progressBarListResult);

        mBtnSearch.setOnClickListener(view -> searchProduct());

        mRecyclerSearchResult = findViewById(R.id.recyclerSearchResult);
        mRecyclerSearchResult.setVisibility(View.INVISIBLE);
        LinearLayoutManager productLayoutManager = new LinearLayoutManager(this);
        utilities.setUpRecyclerView(mRecyclerSearchResult, productLayoutManager);
        ArrayList<ProductModel> products = new ArrayList<>();
        productListAdapter = new ProductListAdapter(this, products);
    }



    private void loadControls() {

        searchApiController = new SearchApiController();
        String strBusqueda = getString(R.string.lblResultados) + Objects.requireNonNull(getIntent().getExtras()).getString("SearchQuery");

        mTxtResultadosBusqueda.setText(strBusqueda);

        disposable = RXProductBus.loadSearchList(productListAdapter, mRecyclerSearchResult, mProgressBar);
    }

    private void searchProduct() {

        mBtnSearch.setClickable(false);
        searchApiController.getProductQueryResults(mTxtSearchBar.getText().toString());
        Intent intentProductList = new Intent(this, ProductListActivity.class);
        intentProductList.putExtra("SearchQuery", mTxtSearchBar.getText().toString());
        startActivity(intentProductList);
        finish();
        mBtnSearch.setClickable(true);

    }



    @Override
    protected void onDestroy(){
        super.onDestroy();
        disposable.dispose();
    }
}
