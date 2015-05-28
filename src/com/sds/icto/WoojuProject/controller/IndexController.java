package com.sds.icto.WoojuProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sds.icto.WoojuProject.domain.BoardVo;
import com.sds.icto.WoojuProject.service.BoardService;

@Controller
public class IndexController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("/index")
	public String index(){
		return "main/index";
	}
	
	@RequestMapping("/main")
	public String main(Model model){
		
		
		BoardVo boardVo = boardService.getBoardtoMain();
		model.addAttribute("vo", boardVo);
		BoardVo boardVo2 = boardService.getBoardtoMain2();
		model.addAttribute("vo2", boardVo2);
		
		return "main/main";
	}
	
	@RequestMapping("/aboutus")
	public String aboutus(){
		return "aboutus/team";
	}
}
