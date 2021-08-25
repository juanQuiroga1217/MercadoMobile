package com.mercadolibreprueba.mercadomobile.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mercadolibreprueba.mercadomobile.R;
import com.mercadolibreprueba.mercadomobile.model.ProductModel;
import com.mercadolibreprueba.mercadomobile.view.ProductDetailsScreen;

import java.text.DecimalFormat;
import java.util.ArrayList;



public class CardProductAdapter extends RecyclerView.Adapter<CardProductAdapter.CardProductAdapterHolder> {

    private Context context;
    private ArrayList<ProductModel> products;
    private ProductDetailsScreen productDetailsScreen;

    public CardProductAdapter(Context context, ArrayList<ProductModel> products) {
        this.context = context;
        this.products = products;
        productDetailsScreen = new ProductDetailsScreen();
    }

    void setProducts(ArrayList<ProductModel> products) {
        this.products = products;
    }



    class CardProductAdapterHolder extends RecyclerView.ViewHolder{

        private ImageView mProductPhoto;
        private TextView mProductName;
        private TextView mProductPrice;
        private TextView mProductShipping;

        CardProductAdapterHolder(@NonNull View itemView) {
            super(itemView);
            mProductPhoto = itemView.findViewById(R.id.imgProductPhoto);
            mProductName = itemView.findViewById(R.id.lblProductName);
            mProductPrice = itemView.findViewById(R.id.lblProductPrice);
            mProductShipping = itemView.findViewById(R.id.lblProductShipping);
        }



        /*
         * Manage List Item Behaviour
         */

        void bind(final ProductModel product){

            mProductName.setText(product.getProductTitle());

            mProductPrice.setText(DecimalFormat.getCurrencyInstance().format(product.getProductPrice()));


            if (product.getProductShipping().isShippingFree()){
                mProductShipping.setText(R.string.lblFreeShipping);
            } else {
                mProductShipping.setVisibility(View.GONE);
            }

            if (product.getProductThumbnail()!=null){
                Glide.with(context).load(product.getProductThumbnail()).into(mProductPhoto);
            }

            itemView.setOnClickListener(view -> {
                itemView.setClickable(false);
                productDetailsScreen.setProductDialog(product, context);
                itemView.setClickable(true);
            });
        }
    }





    @NonNull
    @Override
    public CardProductAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_card_product_element, parent, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(layoutParams);
        return new CardProductAdapterHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CardProductAdapterHolder holder, int position) {
        holder.bind(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


}
