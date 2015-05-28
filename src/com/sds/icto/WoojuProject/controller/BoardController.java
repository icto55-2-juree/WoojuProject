package com.sds.icto.WoojuProject.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sds.icto.WoojuProject.domain.BoardVo;
import com.sds.icto.WoojuProject.domain.MemberVo;
import com.sds.icto.WoojuProject.domain.PollVo;
import com.sds.icto.WoojuProject.domain.ReplyVo;
import com.sds.icto.WoojuProject.service.BoardService;
import com.sds.icto.WoojuProject.service.PollService;
import com.sds.icto.WoojuProject.service.ReplyService;


@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@Autowired
	PollService pollService;
	
	@Autowired
	ReplyService replyService;
	
	@RequestMapping(value="/board_list")
	public String boardListForm(Model model){
		
		List<BoardVo> list = boardService.boardList();
		model.addAttribute("list", list);
		
		return"board/board";
	}
	
	@RequestMapping(value="/getBoard", method=RequestMethod.GET)
	public String boardDetail(@ModelAttribute PollVo pvo, @RequestParam ("bno") int bno, Model model, HttpSession session){
		BoardVo vo = boardService.getBoard(bno);
		model.addAttribute("vo", vo);
		
		List<ReplyVo> list = replyService.replyList(bno);
		model.addAttribute("list", list);
		
		MemberVo member = (MemberVo) session.getAttribute("authMember");
		String id = member.getMid();
		
		List<PollVo> midList = pollService.fetchList(bno);
		for (PollVo pollVo : midList) {
		
		if(pollVo.getMid().equals(id)){
			model.addAttribute("memberId", id);
		}
		}

		int cnt = pollService.getPpro(bno);
		int cnt2 = pollService.getPcon(bno);
		
		model.addAttribute("procnt", cnt);
		model.addAttribute("concnt", cnt2);
		
		return"board/board_view";
		
		
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insertForm(){
		return"board/board_edit";
	}
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(HttpServletRequest req, HttpSession session,
			@RequestParam(value="btitle", defaultValue="btitle") String btitle,
			@RequestParam("bimage") MultipartFile bimage,
			@RequestParam("bcontent") String bcontent
			) throws IllegalStateException, IOException{
		
			boardService.insertBoard(req, session, btitle, bimage, bcontent);
			
			return "redirect:board_list";
	}
	
	@RequestMapping(value="/updateBstatus", method=RequestMethod.POST)
	public String updateBstatus(
			@RequestParam ("bno") int bno){
		
		boardService.updateBstatus(bno);
		
		return "redirect:/board/getBoard?bno=" + bno;
	}
	
	@RequestMapping(value="/insertReply", method=RequestMethod.POST)
	public String insertReply(HttpSession session,
			@RequestParam("mid") String mid,
			@RequestParam("bno") int bno,
			@RequestParam("rcontent") String rcontent
			) throws IllegalStateException, IOException{
		
			replyService.insertReply(session, mid, bno, rcontent);
		
			return "redirect:/board/getBoard?bno=" + bno;
						
	}
	
}
