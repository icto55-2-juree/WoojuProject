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
import com.sds.icto.WoojuProject.service.BoardService;
import com.sds.icto.WoojuProject.service.PollService;


@Controller
@RequestMapping("/poll")
public class PollController {

	@Autowired
	PollService pollService;
	
	@Autowired
	BoardService boardService;
	
	
		
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertPoll(
			HttpServletRequest req,
			HttpSession session,
			
			@RequestParam("bno") int bno
			) {
		String result = req.getParameter("result");
		
		System.out.println(bno);
		System.out.println(result);
		
		
		pollService.insert(req, session, bno, result);
			
			return "redirect:/board/getBoard?bno="+bno;
	}
	
}
