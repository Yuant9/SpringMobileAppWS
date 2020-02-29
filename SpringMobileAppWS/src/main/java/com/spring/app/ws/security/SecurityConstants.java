package com.spring.app.ws.security;

public class SecurityConstants {
	public static final long EXPIRATION_TIME = 864000000;  //10MIN
	public static final String TOKEN_PREFIX="Bearer ";
	public static final String HEAD_STRING = "Authorization";
	public static final String SIGN_UP_URL="/users";
	public static final String TOKEN_SECRET = "kjbnuivgyv";

}
