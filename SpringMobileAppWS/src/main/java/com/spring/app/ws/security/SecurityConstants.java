package com.spring.app.ws.security;

import com.spring.app.ws.SpringApplicationContext;

public class SecurityConstants {
	public static final long EXPIRATION_TIME = 864000000;  //10MIN
	public static final String TOKEN_PREFIX="Bearer ";
	public static final String HEAD_STRING = "Authorization";
	public static final String SIGN_UP_URL="/users";
	//public static final String TOKEN_SECRET = "kjbnuivgyv";

	
	public static String getSecretToken() {
		//use SpringApplicationContext to get bean since SecurityConstants is not a bean
		AppProperties appProperties  = (AppProperties) SpringApplicationContext.getBean("appProperties");
		return appProperties.getTokenSecret();
	}
}
