package com.addevelopment.shankerdelivery.model;

public class ProductsInfoModel {
    int productImg;
    String dissPrice,maxRetailPrice,proTilte,proQuntity,dissPercent,proDiscreption;

    public ProductsInfoModel(int productImg, String dissPrice, String maxRetailPrice, String proTilte, String proQuntity, String dissPercent, String proDiscreption) {
        this.productImg = productImg;
        this.dissPrice = dissPrice;
        this.maxRetailPrice = maxRetailPrice;
        this.proTilte = proTilte;
        this.proQuntity = proQuntity;
        this.dissPercent = dissPercent + "% off";
        this.proDiscreption = proDiscreption;
    }

    public int getProductImg() {
        return productImg;
    }

    public String getDissPrice() {
        return dissPrice;
    }

    public String getMaxRetailPrice() {
        return maxRetailPrice;
    }

    public String getProTilte() {
        return proTilte;
    }

    public String getProQuntity() {
        return proQuntity;
    }

    public String getDissPercent() {
        return dissPercent;
    }

    public String getProDiscreption() {
        return proDiscreption;
    }
}
