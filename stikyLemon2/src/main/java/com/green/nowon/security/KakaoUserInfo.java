package com.green.nowon.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class KakaoUserInfo implements OAuth2User{

	private Set<GrantedAuthority> authorities;
	
	private Map<String, Object> attributes;
	
	public KakaoUserInfo(OAuth2User oAuth2User) {
		this.attributes = (Map<String, Object>)oAuth2User.getAttributes().get("kakao_account");
		this.authorities=(Set<GrantedAuthority>) oAuth2User.getAuthorities();
	}
	
	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
