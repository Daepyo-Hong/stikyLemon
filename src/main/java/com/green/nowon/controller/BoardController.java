package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	//고객센터 페이지
	 @GetMapping("/board-write")
	    public String boardWrite() {
	        return "views/admin/board/board-write";
	    }
	 
	 //문의작성 페이지
	 @GetMapping("/board-list")
	    public String boardList() {
	        return "views/admin/board/board-list";
	    }
	
}
