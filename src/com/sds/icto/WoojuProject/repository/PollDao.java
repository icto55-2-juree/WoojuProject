package com.sds.icto.WoojuProject.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.WoojuProject.domain.BoardVo;
import com.sds.icto.WoojuProject.domain.PollVo;

@Repository
public class PollDao {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	// 글 입력
	public void insert(PollVo vo) {

		sqlMapClientTemplate.insert("poll.insert", vo);

	}

	// mid의 투표 여부 확인
	@SuppressWarnings("unchecked")
	public PollVo getPoll(PollVo vo) {
		
		PollVo pollVo = new PollVo();
		pollVo = (PollVo) sqlMapClientTemplate.queryForObject("poll.getPoll", vo);
		
		return pollVo;

	}
	
	public int getPpro(int bno){
		int cnt =  (int) sqlMapClientTemplate.queryForObject("poll.getPpro", bno);
		
		return cnt; 
	}
	
	public int getPcon(int bno){
		int cnt2 =  (int) sqlMapClientTemplate.queryForObject("poll.getPcon", bno);
		
		return cnt2; 
	}
	
	@SuppressWarnings("unchecked")
	public List<PollVo> fetchList(int bno){ 
		List<PollVo> list = sqlMapClientTemplate.queryForList("poll.getMid", bno);
		
		return list;
	}
	
	

	/*
	 * 
	 * //no받아서 글 삭제 public void delete(int no ){
	 * sqlMapClientTemplate.delete("board.delete", no); }
	 * 
	 * 
	 * 
	 * //글 수정
	 * 
	 * @SuppressWarnings("unchecked") public void updateBoard(int no, String
	 * title, String content){ Map map = new HashMap(); map.put("no", no);
	 * map.put("title", title); map.put("content", content);
	 * sqlMapClientTemplate.update("board.updateBoard", map);
	 * 
	 * }
	 */

}
