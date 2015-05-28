package com.sds.icto.WoojuProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.icto.WoojuProject.domain.MemberVo;
import com.sds.icto.WoojuProject.repository.MemberDao;


@Service
public class MemberService {

	@Autowired
	MemberDao memberDao;
	
	public void joinUser(MemberVo vo) {
		
		memberDao.insert(vo);
	}

	public MemberVo authUser(MemberVo vo) {
		MemberVo memberVo = memberDao.getMember(vo);
		return memberVo;

		
	}

	public void uinfo(String mid, String mpassword) {
		memberDao.uinfo(mid, mpassword);		
	}
		
	
	public MemberVo getBymid(String mid){
		return memberDao.selectBymid(mid);
	}
	
}
