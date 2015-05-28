package com.sds.icto.WoojuProject.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.WoojuProject.domain.BoardVo;



@Repository
public class BoardDao {
	
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	//글 리스트 불러오기
	@SuppressWarnings("unchecked")
	public List<BoardVo> fetchList(){ 
		List<BoardVo> list = sqlMapClientTemplate.queryForList("board.list");
		
		return list;
	}
	
	//글 상세 페이지
		public BoardVo getBoard(int bno){
			BoardVo vo = (BoardVo) sqlMapClientTemplate.queryForObject("board.getBoard", bno);
			
			return vo; 
		}
		
		//조회수 증가
		public void updateCnt(int bno){
			sqlMapClientTemplate.update("board.updateCnt", bno);
			
		}
		
		//글 입력
		public void insert(BoardVo vo ){
			
			sqlMapClientTemplate.insert("board.insert", vo);
			
		}
		
		//투표 
		public void updatePoll(int bno) {
			sqlMapClientTemplate.update("board.updatePoll", bno);
		}
		
		public void updateRno_cnt(int bno) {
			sqlMapClientTemplate.update("reply.updateRno_cnt", bno);
		}

		public BoardVo getBoardtoMain() {
			BoardVo vo = (BoardVo)  sqlMapClientTemplate.queryForObject("board.getBoardtoMain");
			return vo;
		}

		public BoardVo getBoardtoMain2() {
			BoardVo vo2 = (BoardVo)  sqlMapClientTemplate.queryForObject("board.getBoardtoMain2");
			return vo2;
		}

		public void updateBstatus(int bno) {
			sqlMapClientTemplate.update("board.updateBstatus", bno);
			
		}
		

		
	/*
	
	//no받아서 글 삭제
	public void delete(int no ){
		sqlMapClientTemplate.delete("board.delete", no);
	}


	
	//글 수정
	@SuppressWarnings("unchecked")
	public void updateBoard(int no, String title, String content){
		Map map = new HashMap();
		map.put("no", no);
		map.put("title", title);
		map.put("content", content);
		sqlMapClientTemplate.update("board.updateBoard", map);
		
	}
	*/
	
	
	
}
