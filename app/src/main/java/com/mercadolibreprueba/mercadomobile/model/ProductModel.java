package com.mercadolibreprueba.mercadomobile.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductModel {


    @SerializedName("id")
    private String productId;

    @SerializedName("title")
    private String productTitle;

    @SerializedName("seller")
    private HashMap<String, String> productSeller;

    @SerializedName("price")
    private Double productPrice;

    @SerializedName("currency_id")
    private String productCurrencyId;

    @SerializedName("available_quantity")
    private String productAvailableQuantity;

    @SerializedName("sold_quantity")
    private String productSoldQuantity;

    @SerializedName("buying_mode")
    private String productBuyingMode;

    @SerializedName("listing_type_id")
    private String productListingTypeId;

    @SerializedName("stop_time")
    private String productStopTime;

    @SerializedName("condition")
    private String productCondition;

    @SerializedName("permalink")
    private String productPermalink;

    @SerializedName("thumbnail")
    private String productThumbnail;

    @SerializedName("accepts_mercadopago")
    private boolean productAcceptsMercadopago;

    @SerializedName("address")
    private HashMap<String, String> productAddress;

    @SerializedName("shipping")
    private ProductsShippingModel productShipping;

    @SerializedName("attributes")
    private ArrayList<ProductAttributesModel> productAttributes;

    public ProductModel(String productId, String productTitle, HashMap<String, String> productSeller, Double productPrice, String productCurrencyId, String productAvailableQuantity, String productSoldQuantity, String productBuyingMode, String productListingTypeId, String productStopTime, String productCondition, String productPermalink, String productThumbnail, boolean productAcceptsMercadopago, HashMap<String, String> productAddress, ProductsShippingModel productShipping, ArrayList<ProductAttributesModel> productAttributes) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.productSeller = productSeller;
        this.productPrice = productPrice;
        this.productCurrencyId = productCurrencyId;
        this.productAvailableQuantity = productAvailableQuantity;
        this.productSoldQuantity = productSoldQuantity;
        this.productBuyingMode = productBuyingMode;
        this.productListingTypeId = productListingTypeId;
        this.productStopTime = productStopTime;
        this.productCondition = productCondition;
        this.productPermalink = productPermalink;
        this.productThumbnail = productThumbnail;
        this.productAcceptsMercadopago = productAcceptsMercadopago;
        this.productAddress = productAddress;
        this.productShipping = productShipping;
        this.productAttributes = productAttributes;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public HashMap<String, String> getProductSeller() {
        return productSeller;
    }

    public void setProductSeller(HashMap<String, String> productSeller) {
        this.productSeller = productSeller;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCurrencyId() {
        return productCurrencyId;
    }

    public void setProductCurrencyId(String productCurrencyId) {
        this.productCurrencyId = productCurrencyId;
    }

    public String getProductAvailableQuantity() {
        return productAvailableQuantity;
    }

    public void setProductAvailableQuantity(String productAvailableQuantity) {
        this.productAvailableQuantity = productAvailableQuantity;
    }

    public String getProductSoldQuantity() {
        return productSoldQuantity;
    }

    public void setProductSoldQuantity(String productSoldQuantity) {
        this.productSoldQuantity = productSoldQuantity;
    }

    public String getProductBuyingMode() {
        return productBuyingMode;
    }

    public void setProductBuyingMode(String productBuyingMode) {
        this.productBuyingMode = productBuyingMode;
    }

    public String getProductListingTypeId() {
        return productListingTypeId;
    }

    public void setProductListingTypeId(String productListingTypeId) {
        this.productListingTypeId = productListingTypeId;
    }

    public String getProductStopTime() {
        return productStopTime;
    }

    public void setProductStopTime(String productStopTime) {
        this.productStopTime = productStopTime;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductPermalink() {
        return productPermalink;
    }

    public void setProductPermalink(String productPermalink) {
        this.productPermalink = productPermalink;
    }

    public String getProductThumbnail() {
        return productThumbnail;
    }

    public void setProductThumbnail(String productThumbnail) {
        this.productThumbnail = productThumbnail;
    }

    public boolean isProductAcceptsMercadopago() {
        return productAcceptsMercadopago;
    }

    public void setProductAcceptsMercadopago(boolean productAcceptsMercadopago) {
        this.productAcceptsMercadopago = productAcceptsMercadopago;
    }

    public HashMap<String, String> getProductAddress() {
        return productAddress;
    }

    public void setProductAddress(HashMap<String, String> productAddress) {
        this.productAddress = productAddress;
    }

    public ProductsShippingModel getProductShipping() {
        return productShipping;
    }

    public void setProductShipping(ProductsShippingModel productShipping) {
        this.productShipping = productShipping;
    }

    public ArrayList<ProductAttributesModel> getProductAttributes() {
        return productAttributes;
    }

    public void setProductAttributes(ArrayList<ProductAttributesModel> productAttributes) {
        this.productAttributes = productAttributes;
    }
}
