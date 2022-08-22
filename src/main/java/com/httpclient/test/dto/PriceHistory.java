package com.httpclient.test.dto;

import java.math.BigDecimal;

public class PriceHistory {

    private BigDecimal price;
    
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
    

    

}
