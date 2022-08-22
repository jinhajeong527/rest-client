package com.httpclient.test.dto;

public class ProductPayload {
    
    private Product product;
    private PriceHistory priceHistory;

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public PriceHistory getPriceHistory() {
        return priceHistory;
    }
    public void setPriceHistory(PriceHistory priceHistory) {
        this.priceHistory = priceHistory;
    }
    
}
