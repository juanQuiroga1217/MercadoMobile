package com.mercadolibreprueba.mercadomobile.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mercadolibreprueba.mercadomobile.R;
import com.mercadolibreprueba.mercadomobile.model.ProductModel;

import java.text.DecimalFormat;
import java.util.ArrayList;



public class CardProductAdapter extends RecyclerView.Adapter<CardProductAdapter.CardProductAdapterHolder> {

    private Context context;
    private ArrayList<ProductModel> products;

    public CardProductAdapter(Context context, ArrayList<ProductModel> products) {
        this.context = context;
        this.products = products;
    }

    void setProducts(ArrayList<ProductModel> products) {
        this.products = products;
    }



    class CardProductAdapterHolder extends RecyclerView.ViewHolder{

        private ImageView productPhoto;
        private TextView productName;
        private TextView productPrice;
        private TextView productShipping;

        CardProductAdapterHolder(@NonNull View itemView) {
            super(itemView);
            productPhoto = itemView.findViewById(R.id.imgProductPhoto);
            productName = itemView.findViewById(R.id.lblProductName);
            productPrice = itemView.findViewById(R.id.lblProductPrice);
            productShipping = itemView.findViewById(R.id.lblProductShipping);
        }



        /*
         * Manage List Item Behaviour
         */

        void bind(final ProductModel product){

            productName.setText(product.getProductTitle());

            productPrice.setText(DecimalFormat.getCurrencyInstance().format(product.getProductPrice()));


            //TODO crear modelo shipping por que el arreglo de tags no permite pasar el objeto
            if (product.getProductShipping().isShippingFree()){
                productShipping.setText(R.string.lblFreeShipping);
            }

            if (product.getProductThumbnail()!=null){
                Glide.with(context).load(product.getProductThumbnail()).into(productPhoto);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, product.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }





    @NonNull
    @Override
    public CardProductAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_card_product_element, parent, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(lp);
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
