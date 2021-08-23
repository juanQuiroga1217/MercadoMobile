package com.mercadolibreprueba.mercadomobile.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mercadolibreprueba.mercadomobile.R;
import com.mercadolibreprueba.mercadomobile.model.ProductAttributesModel;

import java.util.ArrayList;

public class ProductAttributesAdapter extends RecyclerView.Adapter<ProductAttributesAdapter.ProductAttributesHolder> {

    private Context context;
    private ArrayList<ProductAttributesModel> attributes;

    public ProductAttributesAdapter(Context context, ArrayList<ProductAttributesModel> attributes){
        this.context = context;
        this.attributes = attributes;
    }


    static class ProductAttributesHolder extends RecyclerView.ViewHolder {

        private TextView mProductAttributeName;
        private TextView mProductAttributeValue;

        ProductAttributesHolder(@NonNull View itemView) {
            super(itemView);
            mProductAttributeName = itemView.findViewById(R.id.productAttributeName);
            mProductAttributeValue = itemView.findViewById(R.id.productAttributeValue);
        }

        void bind(final ProductAttributesModel attributes){

            mProductAttributeName.setText(attributes.getProductAttributeName());
            mProductAttributeValue.setText(attributes.getProductAttributeValueName());
        }
    }

    @NonNull
    @Override
    public ProductAttributesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_product_attribute_element, parent, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        return new ProductAttributesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAttributesHolder holder, int position) {
        holder.bind(attributes.get(position));
    }

    @Override
    public int getItemCount() {
        return attributes.size();
    }
}
