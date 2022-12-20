package com.green.nowon.controller;

import com.green.nowon.domain.dto.member.MemberInsertDTO;
import com.green.nowon.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignController {
    @Autowired
    private LogService service;


    // 해더의 login 버튼 눌렀을 때

    @GetMapping("/comm/signin")
    public String signin() {
        return "views/sign/signin";
    }


    //이메일로 로그인하기 버튼 눌렀을 때
    @GetMapping("/comm/emailSignin")
    public String emailLogin() {
        return "views/sign/emailsignin";
    }



    //signup 버튼 눌렸을 때
    //구글/카카오 회원가입버튼 + 이메일로 회원가입하기 버튼있음

    @GetMapping("/comm/signup")
    public String signup() {
        return "views/sign/signup";
    }


     // 이메일로 로그인 시도할때 --> 시큐리티에서 매핑해줌

    /*
    @PostMapping("/members/login")
    public String login(MemberDTO dto){
        return "redirect:/";
    }
    */

   // 이메일로 회원가입하기 버튼 눌렀을 때

    @GetMapping("/comm/emailSignup")
    public String emailSignup() {
        return "views/sign/emailsignup";
    }


    //이메일로 회원가입 제출했을때
    @PostMapping("/comm/signup")
    public String Esignup(MemberInsertDTO dto){
        service.save(dto);
        return "redirect:/comm/emailSignin";
    }
}
