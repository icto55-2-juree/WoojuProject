package com.sds.icto.WoojuProject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sds.icto.WoojuProject.domain.BoardVo;
import com.sds.icto.WoojuProject.domain.ReplyVo;
import com.sds.icto.WoojuProject.service.ReplyService;

@Controller
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired
	ReplyService replyService;
	
	@RequestMapping(value="/insertReply", method=RequestMethod.POST)
	public String insertReply(HttpSession session,
			@RequestParam("mid") String mid,
			@RequestParam("bno") int bno,
			@RequestParam("rcontent") String rcontent
			) throws IllegalStateException, IOException{
		
			replyService.insertReply(session, mid, bno, rcontent);
			
			return "board/board_view";
	}
			
}
