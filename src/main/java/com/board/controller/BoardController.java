package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.domain.BoardVO;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	 @Inject
	 BoardService boardService;

	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	 public void getList(Model model) throws Exception {
	   
		 List<BoardVO> list = boardService.list();
		 
		 model.addAttribute("list",list);
	 }
	 
	 

}
