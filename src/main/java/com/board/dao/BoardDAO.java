package com.board.dao;

import java.util.List;

import com.board.domain.BoardVO;
import com.board.domain.Criteria;
import com.board.domain.SearchCriteria;

public interface BoardDAO {

	/* 전체 글 리스트 조회 */
	public List list() throws Exception; 

	/* 해당 글 조회 */
	public BoardVO read(int bno) throws Exception;
	
	/* 글 작성 */
	public void write(BoardVO boardVO) throws Exception;
	
	/* 해당 글 삭제 */
	public void delete(int bno) throws Exception;
	
	/* 해당 글 수정 */
	public void update(BoardVO boardVO) throws Exception;
	
	/*목록 + 페이징*/
	public List<BoardVO> listPage(Criteria cri) throws Exception;
	
	/*게심ㄹ 총 갯수*/
	public int listCount() throws Exception;
	
	//목록 + 페이징 + 검색
	public List<BoardVO> listSearch(SearchCriteria scri) throws Exception;
	
	//검색 결과 갯수
	public int countSearch(SearchCriteria scri) throws Exception;
}
