package com.example.ivanmariic.zadatakuhp.model;

import com.google.gson.annotations.SerializedName;

public class Currency {

    @SerializedName("buying_rate")
    private double buyingRate;

    @SerializedName("selling_rate")
    private double sellingRate;

    @SerializedName("median_rate")
    private double medianRate;

    @SerializedName("unit_value")
    private int unitValue;

    @SerializedName("currency_code")
    private String currencyCode;

    public double getBuyingRate() {
        return buyingRate;
    }

    public void setBuyingRate(double buyingRate) {
        this.buyingRate = buyingRate;
    }

    public double getSellingRate() {
        return sellingRate;
    }

    public void setSellingRate(double sellingRate) {
        this.sellingRate = sellingRate;
    }

    public double getMedianRate() {
        return medianRate;
    }

    public void setMedianRate(double medianRate) {
        this.medianRate = medianRate;
    }

    public int getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(int unitValue) {
        this.unitValue = unitValue;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
