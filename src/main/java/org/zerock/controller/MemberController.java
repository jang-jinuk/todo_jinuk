package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.MemberVO;
import org.zerock.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member/*")
@Log4j
@AllArgsConstructor
public class MemberController {
	private MemberService service;
	
	@GetMapping("/register")
	public void registerMember() {
		
	}
	@PostMapping("/register")
	public String registerMember(MemberVO member) {
		log.info("registerMember: " + member);
		service.register(member);
		return "redirect:/todoLogin";
	}
}
