//package org.zerock.controller;
//
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.zerock.domain.TodoVO;
//import org.zerock.service.TodoService;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.log4j.Log4j;
//
//@Controller
//@Log4j
//@RequestMapping("/board/*")
//@AllArgsConstructor
//public class BoardController {
//	
//	private TodoService service;
//	
//	@PreAuthorize("isAuthenticated()")
//    @GetMapping("/addList")
//    public void addList() {
//    	
//    }
//	
//	@PreAuthorize("isAuthenticated()")
//    @PostMapping("/addList")
//    public String addList(TodoVO board, RedirectAttributes rttr) {
//    	log.info("usuer addList");
//    	service.register(board);
//    	rttr.addFlashAttribute("result", board.getBno());
//    	return "redirect:/todo/list";
//    }
//    @GetMapping("/get")
//    public void get(@RequestParam("bno") Long bno, Model model) {
//    	log.info("/get");
//    	model.addAttribute("board",service.get(bno));
//    }
//    @PostMapping("/modify")
//    public String modify(TodoVO board, RedirectAttributes rttr) {
//    	log.info("modify:" + board);
//    	
//    	if(service.modify(board)) {
//    		rttr.addFlashAttribute("result", "success");
//    	}
//    	return "redirect:/todo/list";
//    }
//    @PostMapping("/remove")
//    public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
//    	log.info("remove...." + bno);
//    	if (service.remove(bno)) {
//    		rttr.addFlashAttribute("result", "success");
//    	}
//    	return "redirect:/todo/list";
//    }
//}
