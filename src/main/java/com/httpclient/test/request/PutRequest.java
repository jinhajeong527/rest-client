package com.httpclient.test.request;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;


import com.httpclient.test.data.PostAndPutRequestBody;


public class PutRequest {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        httpPutRequest(10);
    }

    public static void httpPutRequest(Integer productId) throws URISyntaxException, IOException, InterruptedException {
        String requestBody = PostAndPutRequestBody.makeProductPayloadToJson();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(new URI("http://localhost:8081/api/product/" + productId))
                            .version(HttpClient.Version.HTTP_2)
                            .PUT(BodyPublishers.ofString(requestBody))
                            .header("Content-Type", "application/json")
                            .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        
        System.out.println("httpGetRequest : " + response.body());
        System.out.println("httpGetRequest Status Code : " + response.statusCode());
    }
    
}
