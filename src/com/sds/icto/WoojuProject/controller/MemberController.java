package com.sds.icto.WoojuProject.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sds.icto.WoojuProject.domain.BoardVo;
import com.sds.icto.WoojuProject.domain.MemberVo;
import com.sds.icto.WoojuProject.service.BoardService;
import com.sds.icto.WoojuProject.service.MemberService;


@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute MemberVo vo, HttpSession session, Model model){
		BoardVo boardVo = boardService.getBoardtoMain();
		model.addAttribute("vo", boardVo);
		BoardVo boardVo2 = boardService.getBoardtoMain2();
		model.addAttribute("vo2", boardVo2);
		BoardVo boardVo3 = boardService.getBoardtoMain3();
		model.addAttribute("vo3", boardVo3);
		
		MemberVo memberVo = memberService.authUser(vo);
		
		if (memberVo == null){
			return "redirect:main/index";
		}else{
			session.setAttribute("authMember", memberVo);
			return"main/main";
			
		}
	}

	/*사용 경계선 =================================================== */
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm(){
		return"member/joinform";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute MemberVo vo){
		memberService.joinUser(vo);
		
		return "redirect:/index";
	}
	
		
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		session.removeAttribute("authMember");
		session.invalidate();
		
		return "redirect:/index";
	}
	
	@RequestMapping(value="/uinfo", method=RequestMethod.GET)
	public String uinfoForm(){
		return"member/uinfoform";
	}
	
	@RequestMapping(value="/uinfo", method=RequestMethod.POST)
	public String uinfoForm(
			@RequestParam ("mid") String mid,
			@RequestParam ("mpassword") String mpassword){
		memberService.uinfo(mid, mpassword);
		return "redirect:/index";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/checkmid", method=RequestMethod.POST)
	@ResponseBody
	public Map checkmid(@RequestParam String mid){
		System.out.println(mid);
		MemberVo vo=memberService.getBymid(mid);
		System.out.println(vo);
		Map map=new HashMap();
		if(vo == null){
			map.put("result", true);
			map.put("msg", "사용가능합니다.");
		}else{
			map.put("result", false);
			map.put("msg", "사용불가합니다.");			
		}
		return map;
	}
}
