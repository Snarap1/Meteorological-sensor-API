package com.firstRESTapiAPP.firtstRESTapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class FirtstResTapiApplicationTests {

	private static String createPersonUrl;

	private static RestTemplate restTemplate;

	private static HttpHeaders headers;

	private final ObjectMapper objectMapper = new ObjectMapper();



	@Test
	void contextLoads() {
	}

	@Test
	public  void creatingThousandMeasures() throws JsonProcessingException {

	}


}
