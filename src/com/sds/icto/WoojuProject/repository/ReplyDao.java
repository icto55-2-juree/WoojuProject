package com.sds.icto.WoojuProject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.WoojuProject.domain.ReplyVo;


@Repository
public class ReplyDao {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	
	//댓글 입력
	public void insert(ReplyVo vo) {
		
		sqlMapClientTemplate.insert("reply.insert", vo);
		
	}

	//글 리스트 불러오기
	@SuppressWarnings("unchecked")
	public List<ReplyVo> fetchList(int bno) {
		List<ReplyVo> list = sqlMapClientTemplate.queryForList("reply.list", bno);
		return list;
	}


}
