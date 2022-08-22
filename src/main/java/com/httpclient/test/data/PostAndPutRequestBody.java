package com.httpclient.test.data;

import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.httpclient.test.dto.PriceHistory;
import com.httpclient.test.dto.Product;
import com.httpclient.test.dto.ProductPayload;

public class PostAndPutRequestBody {
    public static String makeProductPayloadToJson() throws JsonProcessingException {
        
        // ProductPayload 오브젝트 생성해서 Json으로 변환하기
        ProductPayload productPayload = new ProductPayload();
        // String name, Float minCpu, String chargeUnit, String productType
        Product product = new Product("APM", 0.1F, "K8S APP",  "CORE");
        PriceHistory priceHistory = new PriceHistory(new BigDecimal(25000.00));

        productPayload.setProduct(product);
        productPayload.setPriceHistory(priceHistory);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(productPayload);

        return requestBody;
    }
    
}
