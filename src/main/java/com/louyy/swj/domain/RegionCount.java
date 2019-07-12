package com.louyy.swj.domain;

public class RegionCount {
    String region;
    int count;
    double totalPrice;
    double unitPrice;
    double maxUnitPrice;
    double minUnitPrice;
    double maxTotalPrice;
    double minTotalPrice;

    public double getMaxUnitPrice() {
        return maxUnitPrice;
    }

    public void setMaxUnitPrice(double maxUnitPrice) {
        this.maxUnitPrice = maxUnitPrice;
    }

    public double getMinUnitPrice() {
        return minUnitPrice;
    }

    public void setMinUnitPrice(double minUnitPrice) {
        this.minUnitPrice = minUnitPrice;
    }

    public double getMaxTotalPrice() {
        return maxTotalPrice;
    }

    public void setMaxTotalPrice(double maxTotalPrice) {
        this.maxTotalPrice = maxTotalPrice;
    }

    public double getMinTotalPrice() {
        return minTotalPrice;
    }

    public void setMinTotalPrice(double minTotalPrice) {
        this.minTotalPrice = minTotalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
