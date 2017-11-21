package com.psa.test.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.psa.test.entities.Question;
import com.psa.test.entities.QuestionOptions;
import com.psa.test.entities.User;
import com.psa.test.exception.TestException;
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
			HttpSession session) {
		try {
			User user = service.validate(users);
			session.setAttribute("user", user);
			int[] marks = new int[10];
			session.setAttribute("marks", marks);
			return "startTest";
		} catch (Exception e) {
			model.addAttribute("msg", "Invalid username/password");
			return "error";
		}
	}

	@RequestMapping(value = "/showTest", method = RequestMethod.POST)
	public String showTest(@RequestParam("index") int index,
			@RequestParam("currIndex") int currIndex,
			@RequestParam("option") int option, Model model, HttpSession session) {
		try {
			User user = (User) session.getAttribute("user");
			if (user == null) {
				throw new TestException("Unauthorized access");
			}
			Question q = service.getQuestions().get(index);
			List<QuestionOptions> options = service.getQuestionOptions(q);
			model.addAttribute("options", options);
			model.addAttribute("q", q);
			model.addAttribute("index", index);
			int[] marks = (int[]) session.getAttribute("marks");
			if (service.getQuestions().get(currIndex).getCorrectOption() == option)
				marks[currIndex] = 1;
			else
				marks[currIndex] = 0;
			session.removeAttribute("marks");
			session.setAttribute("marks", marks);
			return "Exam";
		} catch (Exception te) {
			model.addAttribute("msg", te.getMessage());
			return "error";
		}
	}

	@RequestMapping(value = "/showTest", method = RequestMethod.GET)
	public String startTest(Model model, HttpSession session) {
		try {
			User user = (User) session.getAttribute("user");
			if (user == null) {
				throw new TestException("Unauthorized access");
			}
			Question q = service.getQuestions().get(0);
			List<QuestionOptions> options = service.getQuestionOptions(q);
			model.addAttribute("options", options);
			model.addAttribute("q", q);
			model.addAttribute("index", 0);
			return "Exam";
		} catch (Exception te) {
			model.addAttribute("msg", te.getMessage());
			return "error";
		}
	}

	@RequestMapping("/complete")
	public String completeTest(@RequestParam("currIndex") int currIndex,
			@RequestParam("option") int option, Model model, HttpSession session) {
		try {
			User user = (User) session.getAttribute("user");
			if (user == null) {
				throw new TestException("Unauthorized access");
			}
			int[] marks = (int[]) session.getAttribute("marks");
			if (service.getQuestions().get(currIndex).getCorrectOption() == option)
				marks[currIndex] = 1;
			else
				marks[currIndex] = 0;
			int result = 0;
			for (int mark : marks) {
				result += mark;
			}
			session.removeAttribute("marks");
			session.setAttribute("result", result);
			return "Result";
		} catch (Exception te) {
			model.addAttribute("msg", te.getMessage());
			return "error";
		}
	}

	@RequestMapping("/logout")
	public String logout(Model model, HttpSession session) {
		User user = new User();
		model.addAttribute("user", user);
		session.invalidate();
		return "login";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	
	@RequestMapping("/register")
	public String register(Model model,@ModelAttribute("user") @Valid User user,BindingResult result) {
		try{
		if(result.hasErrors()){
			model.addAttribute("user",user);
			return "register";
		}
		User newUser=service.register(user);
		return "success";
		}catch(Exception e){
			model.addAttribute("msg",e.getMessage());
			return "error";
		}
	}
}
