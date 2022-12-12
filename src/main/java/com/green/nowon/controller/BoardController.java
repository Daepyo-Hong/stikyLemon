package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	 @GetMapping("/boards")
	    public String boards() {
	        return "views/admin/board/boards";
	    }
	 
	 @GetMapping("/board-list")
	    public String boardList() {
	        return "views/admin/board/board-list";
	    }
	
}
