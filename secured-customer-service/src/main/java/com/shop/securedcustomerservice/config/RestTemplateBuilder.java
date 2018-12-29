package com.shop.securedcustomerservice.config;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

// Spring RestTemplate security, used to customize Rest-Template Client

public class RestTemplateBuilder {
	
	// Configuration of the HttpClient for Username/Password credential
	
	private static HttpClient createHttpClient(String username, String password) {
		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
		provider.setCredentials(AuthScope.ANY, credentials);
		
		HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
		
		return client;
	}
	
	// Configuration of the ClientHttpRequestFactory for Spring RestTemplate
	
	private static ClientHttpRequestFactory createRequestFactory(HttpClient httpClient) {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory= new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setHttpClient(httpClient);
		return clientHttpRequestFactory;
	}
	
	//Configuration of Spring RestTemplate with ClientHttpRequestFactory
	
	public static RestTemplate securityRestTemplateBuilder(String username, String password) {
		HttpClient httpClient = createHttpClient(username, password);
		
		ClientHttpRequestFactory requestFactory = createRequestFactory(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		
		return restTemplate;
	}
}
