package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.board.dao.ReplyDAO;
import com.board.domain.ReplyVO;

@Repository
public class ReplyServiceImpl implements ReplyService{

	@Inject
	private ReplyDAO replyDAO;

	@Override
	public List<ReplyVO> readReply(int bno) throws Exception {
		return replyDAO.readReply(bno);
	}

	@Override
	public void writeReply(ReplyVO replyVO) throws Exception {
		replyDAO.writeReply(replyVO);
	}
	
	
}
