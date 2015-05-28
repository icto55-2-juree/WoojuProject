package com.sds.icto.WoojuProject.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sds.icto.WoojuProject.domain.BoardVo;
import com.sds.icto.WoojuProject.domain.MemberVo;
import com.sds.icto.WoojuProject.repository.BoardDao;


@Service
public class BoardService {

	@Autowired
	BoardDao boardDao;

	public List<BoardVo> boardList() {
		
		return boardDao.fetchList();
		
		
	}
	
public BoardVo getBoard(int bno) {
		
		boardDao.updateCnt(bno);
		BoardVo vo = boardDao.getBoard(bno);
		
		return vo;
	}


public void insertBoard(HttpServletRequest req, HttpSession session, String btitle, MultipartFile bimage, String bcontent) throws IllegalStateException, IOException {
	
	MemberVo authMember = (MemberVo) session.getAttribute("authMember");
	
	BoardVo vo = new BoardVo();
	vo.setBtitle(btitle);
	String filename=bimage.getOriginalFilename();
	if(filename.length()!=0){
	String directory=req.getServletContext().getRealPath("/upload");
	File f=new File(directory, filename);
	bimage.transferTo(f);
	vo.setBimage(filename);
	}else{
		vo.setBimage("nopic.JPG");
	}
	vo.setBcontent(bcontent);
	vo.setMid(authMember.getMid());
	vo.setBview_cnt(0);
	vo.setBstatus("진행중");
	vo.setRno_cnt(0);
	vo.setPstatus(0);
	
	boardDao.insert(vo);
	
}

public BoardVo getBoardtoMain() {
	
	BoardVo vo = boardDao.getBoardtoMain();
	
	return vo;
}

public BoardVo getBoardtoMain2() {
	BoardVo vo2 = boardDao.getBoardtoMain2();
	
	return vo2;
}

public void updateBstatus(int bno) {
	boardDao.updateBstatus(bno);
	
}
	
}
