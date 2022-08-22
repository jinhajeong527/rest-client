package com.httpclient.test;


import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TestApplication {
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException{
		SpringApplication.run(TestApplication.class, args);
	}
}
