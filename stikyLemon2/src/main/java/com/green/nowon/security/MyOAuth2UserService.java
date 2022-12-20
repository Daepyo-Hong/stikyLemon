package com.green.nowon.security;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Map;

public class MyOAuth2UserService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        ///*
//        System.out.println(">>>> getName() : "+oAuth2User.getName());;
//
//        oAuth2User.getAuthorities().forEach(role->{
//            System.out.println(">>>>role : "+role);
//        });

        Map<String, Object> attributes = oAuth2User.getAttributes();
        for(String key : attributes.keySet()){
            System.out.println(">>>> "+key+" : "+attributes.get(key));//key,value
        }
        /*
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        for(String key:response.keySet()){
            System.out.println("response: "+key +" : "+response.get(key));
        }
        */
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        System.out.println("registrationId: "+registrationId);
        
        
         return new MyOAuth2User(oAuth2User, registrationId);
    }
}