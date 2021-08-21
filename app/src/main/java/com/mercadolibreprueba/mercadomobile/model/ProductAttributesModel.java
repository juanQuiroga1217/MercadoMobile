package com.mercadolibreprueba.mercadomobile.model;

import com.google.gson.annotations.SerializedName;

public class ProductAttributesModel {

    @SerializedName("id")
    private String productAttributeId;

    @SerializedName("name")
    private String productAttributeName;

    @SerializedName("value_name")
    private String productAttributeValueName;

    @SerializedName("attribute_group_name")
    private String productAttributeGroupName;

    public ProductAttributesModel(String productAttributeId, String productAttributeName, String productAttributeValueName, String productAttributeGroupName) {
        this.productAttributeId = productAttributeId;
        this.productAttributeName = productAttributeName;
        this.productAttributeValueName = productAttributeValueName;
        this.productAttributeGroupName = productAttributeGroupName;
    }

    public String getProductAttributeId() {
        return productAttributeId;
    }

    public void setProductAttributeId(String productAttributeId) {
        this.productAttributeId = productAttributeId;
    }

    public String getProductAttributeName() {
        return productAttributeName;
    }

    public void setProductAttributeName(String productAttributeName) {
        this.productAttributeName = productAttributeName;
    }

    public String getProductAttributeValueName() {
        return productAttributeValueName;
    }

    public void setProductAttributeValueName(String productAttributeValueName) {
        this.productAttributeValueName = productAttributeValueName;
    }

    public String getProductAttributeGroupName() {
        return productAttributeGroupName;
    }

    public void setProductAttributeGroupName(String productAttributeGroupName) {
        this.productAttributeGroupName = productAttributeGroupName;
    }
}
