package com.mercadolibreprueba.mercadomobile.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mercadolibreprueba.mercadomobile.R;
import com.mercadolibreprueba.mercadomobile.controller.MessagesApp;
import com.mercadolibreprueba.mercadomobile.controller.ProductAttributesAdapter;
import com.mercadolibreprueba.mercadomobile.controller.SearchApiController;
import com.mercadolibreprueba.mercadomobile.controller.Utilities;
import com.mercadolibreprueba.mercadomobile.model.ProductAttributesModel;
import com.mercadolibreprueba.mercadomobile.model.ProductModel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class ProductDetailsScreen {

    private TextView txtProductSeller;
    private TextView txtProductDetailsTitle;
    private ImageView imgProductDetailPhoto;
    private TextView txtProductDetailsPrice;
    private TextView txtProductAcceptsMercadoPago;
    private TextView txtProductHasFreeShipping;

    private ProgressBar productDetailsProgressBar;

    private ProductAttributesAdapter productAttributesAdapter;

    private Button btnVolver;
    private Button btnIrMercadoLibre;
    private RecyclerView recyclerViewAttributes;

    SearchApiController searchApiController;
    Utilities utilities;

    public ProductDetailsScreen(){
        searchApiController = new SearchApiController();
        utilities = new Utilities();
    }

    public void setProductDialog(ProductModel product, Context context){

        final Dialog dialog = new Dialog(context, R.style.Theme_AppCompat_Light_NoActionBar);

        try {

            dialog.setContentView(R.layout.custom_product_details);
            dialog.setCancelable(false);

        } catch (Exception e){
            MessagesApp.LogMessageException(context.getClass(), e);
        }finally {
            setUpProductDialogView(dialog);
            showProductDetailsView(dialog, product, context);
        }

    }

    private void setUpProductDialogView(Dialog dialog) {

        txtProductSeller = dialog.findViewById(R.id.lblProductDetailsSeller);
        txtProductDetailsTitle = dialog.findViewById(R.id.lblProductDetailsTitle);
        txtProductDetailsPrice = dialog.findViewById(R.id.lblProductDetailsPrice);
        txtProductAcceptsMercadoPago = dialog.findViewById(R.id.lblproductDetailsMercadoPago);
        txtProductHasFreeShipping = dialog.findViewById(R.id.lblproductDetailsFreeShipping);


        imgProductDetailPhoto = dialog.findViewById(R.id.ProductDetailsPicture);
        productDetailsProgressBar = dialog.findViewById(R.id.ProductDetailsprogressBar);

        btnVolver = dialog.findViewById(R.id.btnVolver);
        btnIrMercadoLibre = dialog.findViewById(R.id.btnIrMercadoLibre);

        recyclerViewAttributes = dialog.findViewById(R.id.recyclerProductAttributes);

    }

    private void showProductDetailsView(Dialog dialog, ProductModel product, Context context) {

        searchApiController.getSellerData(product.getProductSeller().get("id"), txtProductSeller);

        txtProductDetailsTitle.setText(product.getProductTitle());
        txtProductDetailsPrice.setText(DecimalFormat.getCurrencyInstance().format(product.getProductPrice()));

        if (product.isProductAcceptsMercadopago()){
            txtProductAcceptsMercadoPago.setText(R.string.lblAcceptsMercadoPago);
        }

        if (product.getProductShipping().isShippingFree()){
            txtProductHasFreeShipping.setText(R.string.lblFreeShipping);
        }

        if (product.getProductThumbnail()!=null){
            Glide.with(context).load(product.getProductThumbnail()).into(imgProductDetailPhoto);
            productDetailsProgressBar.setVisibility(View.GONE);
        }


        LinearLayoutManager attributesLayoutManager = new LinearLayoutManager(context);
        utilities.setUpRecyclerView(recyclerViewAttributes, attributesLayoutManager);
        ArrayList<ProductAttributesModel> productAttributes = product.getProductAttributes();
        productAttributesAdapter = new ProductAttributesAdapter(context, productAttributes);

        recyclerViewAttributes.setAdapter(productAttributesAdapter);

        btnVolver.setOnClickListener(view -> dialog.dismiss());

        btnIrMercadoLibre.setOnClickListener(view -> initMercadoLibre(product.getProductPermalink(), context));

        Objects.requireNonNull(dialog.getWindow()).setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);

        dialog.show();

    }


    private void initMercadoLibre(String permalink, Context context){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(permalink));
        context.startActivity(i);
    }

}
