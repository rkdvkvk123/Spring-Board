package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVO;
import com.board.domain.Criteria;
import com.board.domain.PageMaker;
import com.board.domain.ReplyVO;
import com.board.domain.SearchCriteria;
import com.board.service.BoardService;
import com.board.service.ReplyService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	 @Inject
	 BoardService boardService;
	 
	 @Inject
	 ReplyService replyService;
	 
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
			 return "redirect:/write";
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
	 
	 @RequestMapping(value = "/read",method = RequestMethod.GET)
	 public void getRead(@RequestParam("bno") int bno, Model model) throws Exception {
		 logger.info("========= 해당 게시물 페이지 =========");
		 
		 BoardVO boardVO = boardService.read(bno);
		 model.addAttribute("read",boardVO);
		 
		 List<ReplyVO> repList = replyService.readReply(bno);
		 model.addAttribute("repList",repList);
		 
		 logger.info("URL : http://localhost:8090/board/read?bno=" + bno);
	 }
	 
	 // 글 수 정
	 @RequestMapping(value = "/modify", method = RequestMethod.GET)
	 public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {
	  logger.info("========= 수정 페이지 =========");
	  
	  BoardVO vo = boardService.read(bno);
	  
	  model.addAttribute("modify", vo);
	  logger.info("URL : http://localhost:8090/board/read?bno=" + bno);
	  
	 } 
	 
	 // 글 수정  POST 
	 @RequestMapping(value = "/modify", method = RequestMethod.POST)
	 public String postModify(BoardVO vo) throws Exception {
		 logger.info("========= 수정 준비 중.... =========");
		 try {
			 logger.info("========= 수정 하는 중.... =========");
			 boardService.update(vo);
			 logger.info("========= 수정 완료! =========");
		 }catch(Exception e) {
			 logger.info("========= 수정 실패!!!! =========");
			 e.printStackTrace();
		 }
	  
	  return "redirect:/board/list";
	  
	 }
	 
	 
	 // 글 삭제
	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
	 public void getDelete(@RequestParam("bno") int bno, Model model) throws Exception {
	  logger.info("get delete");
	    
	  model.addAttribute("delete", bno);
	  
	 }
	 


	 // 글 삭제  POST
	 @RequestMapping(value = "/delete", method = RequestMethod.POST)
	 public String postDelete(@RequestParam("bno") int bno) throws Exception {
	  logger.info("post delete");
	    
	  boardService.delete(bno);
	  
	  return "redirect:/board/list";
	 }
	 
	 
	 @RequestMapping(value = "/listPage", method = RequestMethod.GET)
	 public void listPage(@ModelAttribute("Cri") Criteria cri,Model model) throws Exception {
		 
		 logger.info("========= 게시물 조회 =========");
		 logger.info("URL : http://localhost:8090/board/list");
		 List<BoardVO> list = boardService.listPage(cri);
		 model.addAttribute("list",list);
		 
		 PageMaker pageMaker = new PageMaker();
		 pageMaker.setCri(cri);
		 pageMaker.setTotalCount(boardService.listCount());
		 model.addAttribute("pageMaker",pageMaker);
	 }
	 
	 @RequestMapping(value="/listSearch",method = RequestMethod.GET)
	 public void listSearch(@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		 logger.info("========= 게시물 조회 =========");
		 logger.info("URL : http://localhost:8090/board/list");
		 List<BoardVO> list = boardService.listSearch(scri);
		 model.addAttribute("list",list);
		 
		 PageMaker pageMaker = new PageMaker();
		 pageMaker.setCri(scri);
		 pageMaker.setTotalCount(boardService.countSearch(scri));
		 model.addAttribute("pageMaker",pageMaker);
	 }
	 
	 
	 

}
