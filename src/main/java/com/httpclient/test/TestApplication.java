package com.httpclient.test;


import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.http.HttpResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.httpclient.test.dto.ProductPayload;
import com.httpclient.test.dto.ProductResponsePayload;
import com.httpclient.test.request.DeleteRequest;
import com.httpclient.test.request.PostRequest;
import com.httpclient.test.request.PutRequest;



@SpringBootApplication
public class TestApplication {
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException{
		SpringApplication.run(TestApplication.class, args);
		System.out.println("상품의 등록 수정 삭제 테스트를 진행하고 싶으면 1을 입력해 주세요");
		Scanner sc = new Scanner(System.in);
		int number = 0;
		try {
			number = sc.nextInt();
			while(true) {
				if(number == 1) {
					PostRequest postRequest = new PostRequest();
					HttpResponse<String> postResponse = postRequest.httpPostRequest(number);
					ObjectMapper objectMapper = new ObjectMapper();
        			TypeReference<ProductResponsePayload> typeReference = new TypeReference<ProductResponsePayload>() {};
        			ProductResponsePayload productResponsePayload = objectMapper.readValue(postResponse.body(), typeReference);

					Integer productId = productResponsePayload.getProduct().getId();
					String name = productResponsePayload.getProduct().getName();
					String producType = productResponsePayload.getProduct().getProductType();
					Float minCpu = productResponsePayload.getProduct().getMinCpu();
					String chargeUnit = productResponsePayload.getProduct().getChargeUnit();
					BigDecimal price = productResponsePayload.getPriceHistory().getPrice();

					System.out.println("등록된 상품 아이디 : " + productId);
        			System.out.println("등록된 상품 이름 : " + name);
					System.out.println("등록된 상품 타입 : " + producType);
					System.out.println("등록된 상품 가격 : " + price);
        			System.out.println("등록된 상품 생성일 : " + productResponsePayload.getProduct().getCreateDate());
        			System.out.println("Http 상태 코드 : " + postResponse.statusCode());
        			System.out.println("방금 등록된 상품 수정을 시작합니다. id: " + productId +", "+ productResponsePayload.getProduct().getName());

        			System.out.println("상품이름은 현재 " + productResponsePayload.getProduct().getName() + "입니다. 수정할 상품 이름을 입력해주세요.");
					Scanner scanner = new Scanner(System.in);
					String editName = scanner.nextLine();

        			ProductPayload productPayload = new ProductPayload(producType, editName, minCpu, chargeUnit, price);
					PutRequest putRequest = new PutRequest();
					HttpResponse<String> putResponse = putRequest.httpPutRequest(productId, productPayload);

					System.out.println("httpPutRequest : " + putResponse.body());
        			System.out.println("httpPutRequest Status Code : " + putResponse.statusCode());

					System.out.println("방금 수정된 상품의 삭제를 진행하겠습니다.");
					HttpResponse<String> deleteResponse = new DeleteRequest().httpDeleteRequest(productId);
					System.out.println("httpDeleteRequest 삭제된 상품의 정보입니다 : " + deleteResponse.body());
        			System.out.println("httpDeleteRequest Status Code : " + deleteResponse.statusCode());
					System.out.println("상품의 삭제가 완료되었습니다.");
					number = 0;

			
				} else {
					System.out.println("테스트를 계속 진행하고 싶으면 1, 프로그램을 종료하고 싶을 경우 다른 번호를 눌러주세요");
					Scanner scanner = new Scanner(System.in);
					number = scanner.nextInt();
					if(number != 1) {
						System.out.println("테스트를 종료합니다.");
						scanner.close();
						System.exit(0);
					}
				}
			}	
		} catch(Exception e) {
			System.out.println("숫자가 아닌 정보 입력으로 프로그램을 종료합니다.");
			System.exit(0);
		} finally{
			sc.close();
		}
	}
}


