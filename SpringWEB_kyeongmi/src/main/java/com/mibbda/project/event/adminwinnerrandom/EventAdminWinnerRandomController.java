package com.mibbda.project.event.adminwinnerrandom;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class EventAdminWinnerRandomController {
	
	RandomCommand command = null;
	

	// 당첨자 10명 랜덤 추천
	@RequestMapping("insertWinEvent")
	public String insertWinEvent(HttpServletRequest request, Model model) {
	
		model.addAttribute("request", request);
		command = new RegisterRandomCommand();
		command.execute(model);
		
		return "redirect:eventListAdmin";
	}
		
}
