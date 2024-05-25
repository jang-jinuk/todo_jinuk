package org.zerock.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.TodoVO;
import org.zerock.service.TodoService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/todo/*")
@Log4j
@AllArgsConstructor
public class TodoController {
	
	private TodoService service;
	
	@GetMapping("/admin")
	public void admin() {
		log.info("logined admin");
	}
	
    @GetMapping("/signup")
    public void signup() {
    	log.info("signup");
    }

	@GetMapping("/list")
    @PreAuthorize("isAuthenticated()")
	public void list(Model model, Principal principal) {
		String userid = principal.getName();
        model.addAttribute("list", service.getList(userid));
		
	}
	
	@GetMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public void register() {
		
	}
	
    @PostMapping("/register")
	@PreAuthorize("isAuthenticated()")
    public String register(TodoVO todo, Principal principal) {
    	log.info("user addList");
    	String userid = principal.getName();
    	todo.setUserid(userid);
    	service.register(todo);
    	
    	return "redirect:/todo/list";
    }
	
    @GetMapping("/get")
	@PreAuthorize("isAuthenticated()")
    public void get(@RequestParam("tno") Long tno, Model model) {
    	log.info("get");
    	model.addAttribute("todo",service.get(tno));
    }
    
    @PostMapping("/modify")
	@PreAuthorize("isAuthenticated()")
    public String modify(TodoVO todo, RedirectAttributes rttr) {
    	log.info("modify:" + todo);
    	
    	if(service.modify(todo)) {
    		rttr.addFlashAttribute("result", "success");
    	}
    	return "redirect:/todo/list";
    }
    
    @PostMapping("/remove")
	@PreAuthorize("isAuthenticated()")
    public String remove(@RequestParam("tno") Long tno, RedirectAttributes rttr) {
    	log.info("remove...." + tno);
    	if (service.remove(tno)) {
    		rttr.addFlashAttribute("result", "success");
    	}
    	return "redirect:/todo/list";
    }
    
    @PostMapping("/complete")
	@PreAuthorize("isAuthenticated()")
    public String complete(@RequestParam("tno") Long tno, RedirectAttributes rttr) {
    	log.info("complete...." + tno);
    	if (service.complete(tno)) {
    		rttr.addFlashAttribute("result", "success");
    	}
    	return "redirect:/todo/list";
    }
  
}

