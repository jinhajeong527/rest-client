package com.httpclient.test.request;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


public class DeleteRequest {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        httpDeleteRequest(1);
    }

    public static void httpDeleteRequest(Integer productId) throws URISyntaxException, IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();
        
		HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create("http://localhost:8081/api/product/" + productId))
			                .version(HttpClient.Version.HTTP_2) // 디폴트 버전이다.
			                .DELETE()
			                .header("Content-Type", "application/json")
                            .build();
			
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        System.out.println("httpGetRequest : " + response.body());
        System.out.println("httpGetRequest Status Code : " + response.statusCode());
    }
}
