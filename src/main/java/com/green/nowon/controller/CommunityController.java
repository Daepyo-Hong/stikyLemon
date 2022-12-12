package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityController {
	
	@GetMapping("/notice")
	    public String notice() {
	        return "views/admin/community/notice";
	    }
	
	 @GetMapping("/faq")
	    public String faq() {
	        return "views/admin/community/faq";
	    }
	 
	 @GetMapping("/review")
	    public String review() {
	        return "views/admin/community/review";
	    }
	 @GetMapping("/review-write")
	    public String reviewWrite() {
	        return "views/admin/community/review-write";
	    }
	 
	 @GetMapping("/event")
	    public String event() {
	        return "views/admin/community/event";
	    }
}
