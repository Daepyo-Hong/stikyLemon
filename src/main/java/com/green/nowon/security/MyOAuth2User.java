package com.green.nowon.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Getter
public class MyOAuth2User implements OAuth2User{
	
	private Map<String, Object> attributes;
	private Set<SimpleGrantedAuthority> authorities; 
	private String nickName;
	private String email;
	private String profileImg;
	
	
	public MyOAuth2User(OAuth2User oAuth2User, String registrationId) {
		if(registrationId.equals("google")) {
			ofGoogle(oAuth2User);
		}else if(registrationId.equals("kakao")) {
			ofKakao(oAuth2User);
		}
	}


	private void ofKakao(OAuth2User oAuth2User) {
		this.attributes=oAuth2User.getAttribute("kakao_account");
		this.authorities = (Set<SimpleGrantedAuthority>) oAuth2User.getAuthorities();
		email=(String) attributes.get("email");
		Map<String, String> profile = (Map<String, String>) attributes.get("profile");
		nickName = profile.get("nickname");
		profileImg=null;
	}


	private void ofNaver(OAuth2User oAuth2User) {
		this.attributes=oAuth2User.getAttribute("response");
		this.authorities = (Set<SimpleGrantedAuthority>) oAuth2User.getAuthorities();
		email=(String) attributes.get("email");
		nickName=(String) attributes.get("name");
		profileImg=(String) attributes.get("profile_img");

	}


	private void ofGoogle(OAuth2User oAuth2User) {
		this.attributes = oAuth2User.getAttributes();
		this.authorities = (Set<SimpleGrantedAuthority>) oAuth2User.getAuthorities();
		email=(String) attributes.get("email");
		nickName=(String) attributes.get("name"); 
		profileImg=(String) attributes.get("picture");
	}


	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}


	@Override
	public String getName() { //로그인 ID에 대응하는 정보
		return email;
	}
		

}
