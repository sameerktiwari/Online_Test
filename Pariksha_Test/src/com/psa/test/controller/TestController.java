package com.psa.test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psa.test.entities.Question;
import com.psa.test.entities.User;
import com.psa.test.service.TestService;

@Controller
public class TestController {
	@Autowired
	TestService service;

	@RequestMapping("/index")
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	@RequestMapping("/validate")
	public String validate(Model model, @ModelAttribute("user") User users,
			HttpSession session, BindingResult result) {
		if (result.hasErrors()) {
			return "login";
		}
		User user = service.validate(users);
		if (user == null)
			return "login";
		session.setAttribute("user", user);
		return "startTest";
	}
	
	@RequestMapping("/showTest")
	public String showTest(@RequestParam("index") int index,Model model,HttpSession session) {
		Question q=service.getQuestions().get(index);
		model.addAttribute("q",q);
		model.addAttribute("index", index);
		return "Exam";
		
	}
}
