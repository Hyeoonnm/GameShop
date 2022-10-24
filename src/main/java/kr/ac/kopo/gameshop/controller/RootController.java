package kr.ac.kopo.gameshop.controller;

import javax.servlet.http.HttpSession;

import kr.ac.kopo.gameshop.model.Game;
import kr.ac.kopo.gameshop.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.gameshop.model.Member;
import kr.ac.kopo.gameshop.service.MemberService;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
public class RootController {
	
	@Autowired
	MemberService service;

	@Autowired
	GameService gameService;
	
	@RequestMapping("/")
	public String index(Model model) {
		Game item = gameService.item(505);

		model.addAttribute("item", item);

		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login") 
	public String login(Member member, HttpSession session) {
		if(service.login(member)) {
			session.setAttribute("member", member);
			
			String targetUrl = (String) session.getAttribute("target_url");
			System.out.println("RootController: " + targetUrl);
			session.removeAttribute("target_url");
			
			if(targetUrl == null)
				return "redirect:.";
			else
				return "redirect:" + targetUrl;
		} else
			return "redirect:login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:.";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signup(Member item) {
		service.signup(item);
		
		return "redirect:.";
	}
	
	@ResponseBody
	@GetMapping("/checkId/{id}")
	public String checkId(@PathVariable String id) {	
		if(service.checkId(id))
			return "OK";
		else
			return "FAIL";
	}

}
