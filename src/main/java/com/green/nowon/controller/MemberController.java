package com.green.nowon.controller;

import com.green.nowon.security.MyUserDetails;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class MemberController {


    //소셜이든 기본로그인이든 myUserDetails 로 참조할 수 있음
    @GetMapping("/members/info")
    public String memberInfo(@AuthenticationPrincipal MyUserDetails myUserDetails) {
        log.info("Member정보...............");
        log.info("------------------------------------------");
        log.info(myUserDetails);
        log.info("myUserDetails.isSocial()"+myUserDetails.isSocial());
        log.info("myUserDetails.getName()"+myUserDetails.getName());
        log.info("myUserDetails.getAttributes()"+myUserDetails.getAttributes());

        return "views/user/info";
    }

}
