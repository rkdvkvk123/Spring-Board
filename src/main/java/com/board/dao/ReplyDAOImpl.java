package com.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.board.mappers.replyMapper";
	
	@Override
	public List<ReplyVO> readReply(int bno) throws Exception {
		return sql.selectList(namespace + ".readReply",bno);
	}

	@Override
	public void writeReply(ReplyVO replyVO) throws Exception {
		sql.insert(namespace + ".writeReply",replyVO);
	}

	
}
