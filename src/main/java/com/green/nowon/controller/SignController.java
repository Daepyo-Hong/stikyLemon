package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.domain.dto.member.MemberInsertDTO;
import com.green.nowon.service.LogService;

@Controller
public class SignController {
	
	@Autowired
	private LogService service;

    /**
     * 해더의 login 버튼 눌렀을 때
     * 로그인페이지로 이동
     */
    @GetMapping("/signin")
    public String signin() {
        return "views/sign/signin";
    }

    /**
     * 이메일로 로그인하기 버튼 눌렀을 때
     *이메일로그인 페이지로 이동 
     */
    @GetMapping("/emailSignin")
    public String logup() {
        return "views/sign/emailsignin";
    }


    /**
     * signup 버튼 눌렸을 때
     * 구글/카카오 회원가입버튼 + 이메일로 회원가입하기 버튼있음
     * 소셜 회원가입 페이지로 이동
     */
    @GetMapping("/socSignup")
    public String signup() {
        return "views/sign/signup";
    }

    /**
     * 이메일로 회원가입하기 버튼 눌렀을 때
     * 이메일 회원가입 페이지로 이동
     */
    @GetMapping("/emailSignup")
    public String login() {
        return "views/sign/emailsignup";
    }
    /**
     * 
     * 이메일로 회원가입 처리 포스트매핑
     * 이메일 회원가입 처리
     */
    @PostMapping("/signUpForm")
	public String logingo(MemberInsertDTO dto) {
    	service.save(dto); //멤버추가디티오에 저장한다는뜻
	    return "redirect:views/sign/emailsignin"; //회원가입 하면 저장되고 로그인페이지로 보내줌
	}
}