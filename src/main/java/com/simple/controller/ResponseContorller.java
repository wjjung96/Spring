package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/response")
public class ResponseContorller {
	
	//res_ex01화면처리
	@RequestMapping("/res_ex01")
	public void res_ex01() {
		
	}
	
	//Model전달자 - 화면으로 전달할 데이터를 addAttribute(키, 값)
	@RequestMapping("/res_ex02")
	public String res_ex02(Model model) {
		
		
		model.addAttribute("serverTime", new Date());
		model.addAttribute("name", "홍길동");
		
		
		return "response/res_ex02";
	}
	
	//ModelAndView방법 - 데이터 addObject(키,값) , 화면정보 setViewName()
	@RequestMapping("/res_ex03")
	public ModelAndView res_ex03() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("serverTime", new Date());
		mv.setViewName("response/res_ex03");
		
		return mv; //디스패쳐 서블릿으로 반환
	}
	
	//@ModelAttribute전달자 - @RequestParam + Model
	@RequestMapping("/res_ex04")
	public String res_ex04(@ModelAttribute("id") String a ) {
		
		System.out.println("넘어온값:" + a);
		
		return "response/res_ex04";
	}
	
	//@ModelAttribute여러값
	@RequestMapping("/res_ex05")
	public String res_ex05(@ModelAttribute("info") ReqVO vo) {
		
		System.out.println("넘어온값:" + vo.toString());
			
		
		return "response/res_ex05";
	}
	
	//================리다이렉트와 리다이렉트어트리뷰트==================
	//화면처리
	@RequestMapping("/res_redirect")
	public void res_redirect() {
		
	}

	//가정 - 아이디 비밀번호가 동일하면 성공화면, 다르다면 다시 로그인화면으로 이동
	@RequestMapping("/login")
	public String login(ReqVO vo,
						RedirectAttributes RA ) {
		
		if(vo.getId().equals(vo.getPw() )) { //성공
			
			return "response/res_login_ok";
			
		} else { //실패
			//redirect:/절대경로 - 다시 컨트롤러를 타게한다. 
			//이때 화면에 1회성 데이터로 값을 전달하고 싶다면
			//RedirectAttribute객체의 addFlashAttribute를 이용합니다.
			RA.addFlashAttribute("msg", "아이디 비밀번호를 확인하세요");
			
			return "redirect:/response/res_redirect"; //다시 로그인화면
		}
		
	}
	
	//===================문제========================
	
	//화면처리
	@RequestMapping("/res_quiz01")
	public String res_quiz01() {
		return "response/res_quiz01";
	}
	
	//요청처리
	@RequestMapping(value = "/res_login", method = RequestMethod.POST)
	public ModelAndView res_login(@RequestParam("id") String id,
							@RequestParam("pw") String pw) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		
		if(id.equals("kim12") && pw.equals("1234") ) { //성공
			mv.setViewName("response/res_quiz02");
		} else { //실패
			mv.setViewName("response/res_quiz03");
		}

		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
}
