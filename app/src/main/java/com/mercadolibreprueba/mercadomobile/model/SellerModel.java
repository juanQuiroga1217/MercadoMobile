package com.mercadolibreprueba.mercadomobile.model;

public class SellerModel {

    private String sellerId;
    private String sellerNickname;
    private String sellerPermalink;
    private String sellerRegistrationDate;
    private boolean sellerIsRealEstateAgency;
    private boolean sellerIsCarDealer;
    private String[] sellerTags;

    public SellerModel(String sellerId, String sellerNickname, String sellerPermalink, String sellerRegistrationDate, boolean sellerIsRealEstateAgency, boolean sellerIsCarDealer, String[] sellerTags) {
        this.sellerId = sellerId;
        this.sellerNickname = sellerNickname;
        this.sellerPermalink = sellerPermalink;
        this.sellerRegistrationDate = sellerRegistrationDate;
        this.sellerIsRealEstateAgency = sellerIsRealEstateAgency;
        this.sellerIsCarDealer = sellerIsCarDealer;
        this.sellerTags = sellerTags;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerNickname() {
        return sellerNickname;
    }

    public void setSellerNickname(String sellerNickname) {
        this.sellerNickname = sellerNickname;
    }

    public String getSellerPermalink() {
        return sellerPermalink;
    }

    public void setSellerPermalink(String sellerPermalink) {
        this.sellerPermalink = sellerPermalink;
    }

    public String getSellerRegistrationDate() {
        return sellerRegistrationDate;
    }

    public void setSellerRegistrationDate(String sellerRegistrationDate) {
        this.sellerRegistrationDate = sellerRegistrationDate;
    }

    public boolean isSellerIsRealEstateAgency() {
        return sellerIsRealEstateAgency;
    }

    public void setSellerIsRealEstateAgency(boolean sellerIsRealEstateAgency) {
        this.sellerIsRealEstateAgency = sellerIsRealEstateAgency;
    }

    public boolean isSellerIsCarDealer() {
        return sellerIsCarDealer;
    }

    public void setSellerIsCarDealer(boolean sellerIsCarDealer) {
        this.sellerIsCarDealer = sellerIsCarDealer;
    }

    public String[] getSellerTags() {
        return sellerTags;
    }

    public void setSellerTags(String[] sellerTags) {
        this.sellerTags = sellerTags;
    }
}
