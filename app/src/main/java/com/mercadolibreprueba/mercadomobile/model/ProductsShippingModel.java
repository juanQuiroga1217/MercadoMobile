package com.mercadolibreprueba.mercadomobile.model;

import com.google.gson.annotations.SerializedName;

public class ProductsShippingModel {

    @SerializedName("free_shipping")
    private boolean shippingFree;

    @SerializedName("mode")
    private String shippingMode;

    @SerializedName("tags")
    private String[] shippingTags;

    @SerializedName("logistic_type")
    private String shippingLogisticType;

    @SerializedName("store_pick_up")
    private boolean shippingStorePickup;

    public ProductsShippingModel(boolean shippingFree, String shippingMode, String[] shippingTags, String shippingLogisticType, boolean shippingStorePickup) {
        this.shippingFree = shippingFree;
        this.shippingMode = shippingMode;
        this.shippingTags = shippingTags;
        this.shippingLogisticType = shippingLogisticType;
        this.shippingStorePickup = shippingStorePickup;
    }

    public boolean isShippingFree() {
        return shippingFree;
    }

    public void setShippingFree(boolean shippingFree) {
        this.shippingFree = shippingFree;
    }

    public String getShippingMode() {
        return shippingMode;
    }

    public void setShippingMode(String shippingMode) {
        this.shippingMode = shippingMode;
    }

    public String[] getShippingTags() {
        return shippingTags;
    }

    public void setShippingTags(String[] shippingTags) {
        this.shippingTags = shippingTags;
    }

    public String getShippingLogisticType() {
        return shippingLogisticType;
    }

    public void setShippingLogisticType(String shippingLogisticType) {
        this.shippingLogisticType = shippingLogisticType;
    }

    public boolean isShippingStorePickup() {
        return shippingStorePickup;
    }

    public void setShippingStorePickup(boolean shippingStorePickup) {
        this.shippingStorePickup = shippingStorePickup;
    }
}
