package com.lcwd.user.UserService.Config.interceptor;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;



public class RestTemplateInterceptor implements ClientHttpRequestInterceptor{

	private OAuth2AuthorizedClientManager manager;
	
	
	private Logger logger= LoggerFactory.getLogger(RestTemplateInterceptor.class);

	
	
	
	
	public RestTemplateInterceptor(OAuth2AuthorizedClientManager manager) {
		System.out.println(" i an in checking mode====="+manager);
		
		this.manager = manager;
	}





	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		System.out.println("This is rest interceptor");
		String tokenValue=manager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client").principal("internal").build()).getAccessToken().getTokenValue();
		request.getHeaders().add("Authorization", "Bearer"+tokenValue);
		return execution.execute(request, body);
	}

}
