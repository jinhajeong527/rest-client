package com.httpclient.test.data;

import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.httpclient.test.dto.ProductPayload;

public class PostAndPutRequestBody {

    public static String makeProductPayloadToJson() throws MalformedURLException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ProductPayload productPayload = 
            objectMapper.readValue(new URL("file:src/main/resources/postPutRequestTest1.json"), ProductPayload.class);
        String requestBody = objectMapper.writeValueAsString(productPayload);
        return requestBody;
    }
}
