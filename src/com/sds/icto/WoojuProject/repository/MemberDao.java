package com.sds.icto.WoojuProject.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.WoojuProject.domain.MemberVo;

@Repository
public class MemberDao {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	public void insert(MemberVo vo) {

		sqlMapClientTemplate.insert("member.insert", vo);

	}

	public MemberVo getMember(MemberVo vo) {
		MemberVo memberVo = new MemberVo();

		memberVo = (MemberVo) sqlMapClientTemplate.queryForObject(
				"member.getMember", vo);

		return memberVo;
	}

	

	public void uinfo(String mid, String mpassword) {
		Map map = new HashMap();
		map.put("mid", mid);
		map.put("mpassword", mpassword);
		
		sqlMapClientTemplate.update("member.uinfo", map);
				
	}
	
	public MemberVo selectBymid(String mid){
		MemberVo vo=null;
		vo=(MemberVo)sqlMapClientTemplate.queryForObject("member.selectBymid", mid);
		return vo;
	}
}
