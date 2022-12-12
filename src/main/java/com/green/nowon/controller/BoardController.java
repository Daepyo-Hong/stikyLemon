package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	 @GetMapping("/board-write")
	    public String boardWrite() {
	        return "views/admin/board/board-write";
	    }
	 
	 @GetMapping("/board-list")
	    public String boardList() {
	        return "views/admin/board/board-list";
	    }
	
}
