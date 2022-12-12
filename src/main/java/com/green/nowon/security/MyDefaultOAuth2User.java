package com.green.nowon.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

public class MyDefaultOAuth2User extends DefaultOAuth2User{
	
	private String nickName;

	public MyDefaultOAuth2User(Collection<? extends GrantedAuthority> authorities, Map<String, Object> attributes,
                               String nameAttributeKey) {
		super(authorities, attributes, nameAttributeKey);
	}
	
	public MyDefaultOAuth2User(OAuth2User oAuth2User) {
		super(oAuth2User.getAuthorities(), oAuth2User.getAttributes(), "email");
		
		this.nickName = oAuth2User.getAttribute("name");
	}

	public MyDefaultOAuth2User(OAuth2User oAuth2User, String userNameAttributeName) {
		super(oAuth2User.getAuthorities(), (Map<String, Object>)oAuth2User.getAttributes().get(userNameAttributeName), "email");
		
		this.nickName = (String)((Map<String, Object>)oAuth2User.getAttributes().get(userNameAttributeName)).get("name");
	}
}
