package com.httpclient.test.dto;

import java.math.BigDecimal;

public class PriceHistory {
    private Integer id;
    private BigDecimal price;
    private String createDate;
    
    public PriceHistory() {
    }
    
    public PriceHistory(BigDecimal price) {
        this.price = price;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    
    

    

}
