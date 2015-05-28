package com.sds.icto.WoojuProject.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sds.icto.WoojuProject.domain.MemberVo;
import com.sds.icto.WoojuProject.domain.PollVo;
import com.sds.icto.WoojuProject.repository.BoardDao;
import com.sds.icto.WoojuProject.repository.PollDao;

@Service
public class PollService {

	@Autowired
	PollDao pollDao;

	@Autowired
	BoardDao boardDao;

	public void insert(HttpServletRequest req, HttpSession session, int bno,
			String result) {
		MemberVo authMember = (MemberVo) session.getAttribute("authMember");
		PollVo vo = new PollVo();
		vo.setBno(bno);
		vo.setMid(authMember.getMid());
		if (result.equals("ppro")) {
			vo.setPpro(1);
			vo.setPcon(0);
		} else {
			vo.setPpro(0);
			vo.setPcon(1);
		}
		pollDao.insert(vo);
	}

	public PollVo getPoll(PollVo vo) {

		PollVo pollVo = pollDao.getPoll(vo);

		return pollVo;
	}

	public int getPpro(int bno) {

		int cnt = pollDao.getPpro(bno);

		return cnt;
	}

	public int getPcon(int bno) {

		int cnt2 = pollDao.getPcon(bno);

		return cnt2;
	}

	public List<PollVo> fetchList(int bno) {

		return pollDao.fetchList(bno);
	}

}
