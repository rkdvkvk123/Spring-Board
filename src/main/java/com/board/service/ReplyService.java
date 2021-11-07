package com.board.service;

import java.util.List;

import com.board.domain.ReplyVO;

public interface ReplyService {

	//댓글 조회
	public List<ReplyVO> readReply(int bno) throws Exception;
	
	//댓글 작성
	public void writeReply(ReplyVO replyVO) throws Exception;
	
}
