package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	
	//고객센터 페이지
	 @GetMapping("/members/board-list")
	    public String boardList() {
	        return "community/board/board-list";
	    }
	
    //문의작성 페이지
	 @GetMapping("/members/board-write")
	    public String boardWrite() {
	        return "community/board/board-write";
	    }
	 
	
	
}
