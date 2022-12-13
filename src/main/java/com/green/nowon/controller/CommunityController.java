package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityController {
	
	//공지사항 페이지
	@GetMapping("/notice")
	    public String notice() {
	        return "views/admin/community/notice";
	    }
	//자주묻는질문 페이지
	 @GetMapping("/faq")
	    public String faq() {
	        return "views/admin/community/faq";
	    }
	 //리뷰 페이지
	 @GetMapping("/review")
	    public String review() {
	        return "views/admin/community/review";
	    }
	 //리뷰작성 페이지
	 @GetMapping("/review-write")
	    public String reviewWrite() {
	        return "views/admin/community/review-write";
	    }
	 //이벤트 페이지
	 @GetMapping("/event")
	    public String event() {
	        return "views/admin/community/event";
	    }
}
