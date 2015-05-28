package com.sds.icto.WoojuProject.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.icto.WoojuProject.domain.BoardVo;
import com.sds.icto.WoojuProject.domain.MemberVo;
import com.sds.icto.WoojuProject.domain.ReplyVo;
import com.sds.icto.WoojuProject.repository.BoardDao;
import com.sds.icto.WoojuProject.repository.ReplyDao;

@Service
public class ReplyService {

	@Autowired
	ReplyDao replyDao;
	
	@Autowired
	BoardDao boardDao;
	
	public void insertReply(HttpSession session,
			String mid, int bno, String rcontent) {
		
		MemberVo authMember = (MemberVo) session.getAttribute("authMember");
		
		ReplyVo vo = new ReplyVo();
		
		vo.setMid(authMember.getMid());
		vo.setBno(bno);
		vo.setRcontent(rcontent);
		
		boardDao.updateRno_cnt(bno);
		replyDao.insert(vo);
		
	}

	public List<ReplyVo> replyList(int bno) {
		
		return replyDao.fetchList(bno);
	}

}
