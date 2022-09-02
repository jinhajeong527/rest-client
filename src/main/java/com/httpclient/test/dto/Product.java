package com.httpclient.test.dto;


public class Product {

    private Integer id;
    private String name;
    private Float minCpu;
    private String chargeUnit;
    private String productType;
    private String createDate;
    private String updateDate;

    public Product() {
    }
    
    public Product(String name, Float minCpu, String chargeUnit, String productType) {
        this.name = name;
        this.minCpu = minCpu;
        this.chargeUnit = chargeUnit;
        this.productType = productType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    

    
}
