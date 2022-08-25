package com.httpclient.test.request;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.stereotype.Component;

@Component
public class GetRequest {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        //httpGetRequest();
        httpGetRequest("0", "3", "createDate,desc");
    }
    
    public static void httpGetRequest() throws URISyntaxException, IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();
        
		HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create("http://localhost:8081/api/product"))
			                .version(HttpClient.Version.HTTP_2) // 디폴트 버전이다.
			                .GET()
			                .header("Content-Type", "application/json")
                            .build();
			
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        System.out.println("httpGetRequest : " + response.body());
        System.out.println("httpGetRequest Status Code : " + response.statusCode());
    }

    public static void httpGetRequest(String page, String size, String sort) throws URISyntaxException, IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();
        // 자바 HttpClient API 쿼리 파라미터를 위한 메서드 제공하지 않아 직접 작성함

        String params = makePagingAndSortingParam(page, size, sort);

		HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create("http://localhost:8081/api/product/paging" + params))
			                .version(HttpClient.Version.HTTP_2) // 디폴트 버전이다.
			                .GET()
			                .header("Content-Type", "application/json")
                            .build();
			
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        String responseBody = response.body();
        int responseStatusCode = response.statusCode();

        System.out.println("httpGetRequest : " + responseBody);
        System.out.println("httpGetRequest Status Code : " + responseStatusCode);
    }

    private static String makePagingAndSortingParam(String page, String size, String sort) {
        String params = "";
        params += "?page=" + page;
        params += "&size=" + size;
        if(sort != null) 
            params += "&sort=" + sort;
        return params;
    }
    
}
