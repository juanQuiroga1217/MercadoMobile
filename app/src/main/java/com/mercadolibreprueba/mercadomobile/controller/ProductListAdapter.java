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

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductListHolder> {


    private Context context;
    private ArrayList<ProductModel> products;
    private ProductDetailsScreen productDetailsScreen;


    public ProductListAdapter(Context context, ArrayList<ProductModel> products){
        this.context = context;
        this.products = products;
        productDetailsScreen =  new ProductDetailsScreen();
    }


    public void setProducts(ArrayList<ProductModel> products){
        this.products = products;
    }


    class ProductListHolder extends RecyclerView.ViewHolder {

        private ImageView mProductThumbnailPicture;
        private TextView mProductTitle;
        private TextView mProductPrice;
        private TextView mProductShipping;

        ProductListHolder(@NonNull View itemView) {
            super(itemView);

            mProductThumbnailPicture = itemView.findViewById(R.id.productThumbnailPicture);
            mProductTitle = itemView.findViewById(R.id.txtProductTitleList);
            mProductPrice = itemView.findViewById(R.id.txtProductPriceList);
            mProductShipping = itemView.findViewById(R.id.lblProductShipping);

        }

        void bind(Context context, final ProductModel product){

            mProductTitle.setText(product.getProductTitle());
            mProductPrice.setText(DecimalFormat.getCurrencyInstance().format(product.getProductPrice()));

            if (product.getProductShipping().isShippingFree()){
                mProductShipping.setText(R.string.lblFreeShipping);
            } else {
                mProductShipping.setVisibility(View.GONE);
            }

            if (product.getProductThumbnail()!=null){
                Glide.with(context).load(product.getProductThumbnail()).into(mProductThumbnailPicture);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    productDetailsScreen.setProductDialog(product, context);
                }
            });
        }
    }


    @NonNull
    @Override
    public ProductListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_product_element, parent, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        return new ProductListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListHolder holder, int position) {
        holder.bind(context, products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
