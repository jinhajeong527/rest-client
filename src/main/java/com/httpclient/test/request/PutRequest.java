package com.httpclient.test.request;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.httpclient.test.dto.ProductPayload;


public class PutRequest {
    public HttpResponse<String> httpPutRequest(Integer productId, ProductPayload productPayload) throws URISyntaxException, IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(productPayload);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(new URI("http://localhost:8081/api/product/" + productId))
                            .version(HttpClient.Version.HTTP_2)
                            .PUT(BodyPublishers.ofString(requestBody))
                            .header("Content-Type", "application/json")
                            .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        return response;
        
    }
    
}
