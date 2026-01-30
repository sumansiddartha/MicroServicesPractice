package com.lcwd.gateway.APIGateway.Controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.gateway.APIGateway.Model.AuthResponse;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/auth")
public class ApiController {
private Logger logger=LoggerFactory.getLogger(ApiController.class);


@GetMapping("/login")
public ResponseEntity<AuthResponse> login(@RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
											@AuthenticationPrincipal OidcUser user,Model model){
												
	logger.info("user Email id : {}",user.getEmail());
	
	
	AuthResponse authResponse = new AuthResponse();
	
	
	logger.info("Access token value: {}",client.getAccessToken().getTokenValue());
	logger.info("Refresh token value: {}",client.getRefreshToken().getTokenValue());
	authResponse.setUserId(user.getEmail());
	authResponse.setAccessToken(client.getAccessToken().getTokenValue());
	authResponse.setRefreshToken(client.getRefreshToken().getTokenValue());
	authResponse.setExpireAt(client.getAccessToken().getExpiresAt().getEpochSecond());
	List<String> authoritiesList = user.getAuthorities().stream().map(grantedAuthority->{
		return grantedAuthority.getAuthority();
	}).collect(Collectors.toList());
	authResponse.setAuthorities(authoritiesList);
	return new ResponseEntity<AuthResponse>(authResponse,HttpStatus.OK);
	
}

}
