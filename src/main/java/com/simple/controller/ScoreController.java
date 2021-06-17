package com.simple.controller;

import java.util.ArrayList;

import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ScoreVO;
import com.simple.service.ScoreService;
import com.simple.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ScoreController {
	
	
	//멤버변수
	//1st
	//private ScoreService scoreService = new ScoreServiceImpl();
	
	//2nd
//	@Autowired
//	@Qualifier("scoreService")
//	private ScoreService scoreService;
	
	//3nd
	@Autowired
	@Qualifier("scoreService")
	private ScoreService scoreService;
	
	
	
	//목록 화면(화면으로 이동할 때 list를 가지고 나간다)
	@RequestMapping("/scoreList")
	public void scoreList(Model model) {
		
		//화면에서는 list이름으로 데이터를 처리
		
		//ArrayList<ScoreVO> list = scoreService.getList();
		model.addAttribute("list", scoreService.getList() );
		
	}
	
	//등록 화면
	@RequestMapping("/scoreRegist")
	public void scoreRegist() {
		
	}
	
	//결과 화면
	@RequestMapping("/scoreResult")
	public void scoreResult() {
		
	}
	
	//등록요청
	@RequestMapping("regist")
	public String regist(ScoreVO vo) {
		
		scoreService.regist(vo);
		
		
		return "service/scoreResult";
	}
	
	//삭제요청
	@RequestMapping("scoreDelete")
	public String delete(@RequestParam("num") int num ) {


//		scoreSerivce.delete(num);
//		
//		RA.addFlashAttribute()
		
		return "redirect:/service/scoreList";
	}
	
	
	
	
	
}
