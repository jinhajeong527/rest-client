package com.httpclient.test.data;

public class PaginationRequestBody {
    String page;
    String size;
    String sort;
    String order;

    public String getPage() {
        return page;
    }
    public void setPage(String page) {
        this.page = page;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getSort() {
        return sort;
    }
    public void setSort(String sort) {
        this.sort = sort;
    }
    public String getOrder() {
        return order;
    }
    public void setOrder(String order) {
        this.order = order;
    }
    
}
