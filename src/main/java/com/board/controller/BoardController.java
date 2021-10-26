package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	 
	 private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	 @RequestMapping(value = "/write",method = RequestMethod.GET)
	 public void getWrite() throws Exception {
		 logger.info("========= 게시물 작성 페이지 =========");
		 logger.info("URL : http://localhost:8090/board/write");
	 }
	
	 @RequestMapping(value = "/write",method = RequestMethod.POST)
	 public String postWrite(BoardVO boardVO) throws Exception {
		 logger.info("========= 게시물 작성 준비 중.... =========");
		 try {
			 logger.info("========= 게시물 작성 중.... =========");
			 boardService.write(boardVO);
			 logger.info("========= 게시물 작성 완료! =========");
		 }catch(Exception e) {
			 logger.info("========= 게시물 작성 실패!!!! =========");
			 e.printStackTrace();
		 }
		 
		 return "redirect:/";
	 }
	 
	 
	 
	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	 public void getList(Model model) throws Exception {
		 
		 logger.info("========= 게시물 조회 =========");
		 logger.info("URL : http://localhost:8090/board/list");
		 List<BoardVO> list = boardService.list();
		 
		 model.addAttribute("list",list);
	 }
	 
	 

}
