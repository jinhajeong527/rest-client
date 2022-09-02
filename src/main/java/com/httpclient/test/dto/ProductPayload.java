package com.httpclient.test.dto;

import java.math.BigDecimal;

public class ProductPayload {
    
    String productType;
    String name;
    Float minCpu;
    String chargeUnit;
    BigDecimal price;
    
    public ProductPayload() {
    }
    public ProductPayload(String productType, String name, Float minCpu, String chargeUnit, BigDecimal price) {
        this.productType = productType;
        this.name = name;
        this.minCpu = minCpu;
        this.chargeUnit = chargeUnit;
        this.price = price;
    }
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Float getMinCpu() {
        return minCpu;
    }
    public void setMinCpu(Float minCpu) {
        this.minCpu = minCpu;
    }
    public String getChargeUnit() {
        return chargeUnit;
    }
    public void setChargeUnit(String chargeUnit) {
        this.chargeUnit = chargeUnit;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    
    
}
