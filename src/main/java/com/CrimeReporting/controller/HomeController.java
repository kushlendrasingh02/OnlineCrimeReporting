package com.CrimeReporting.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.CrimeReporting.dao.UserRepository;
import com.CrimeReporting.entities.User;
import com.CrimeReporting.helper.Message;

@Controller
public class HomeController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("title", "Home - Online Crime Reporting System");
		return "home";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About - Online Crime Reporting System");
		return "about";
	}

	@RequestMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("title", "Contact - Online Crime Reporting System");
		return "contact";
	}

	@RequestMapping("/blog")
	public String blog(Model model) {
		model.addAttribute("title", "blog - Online Crime Reporting System");
		return "blog";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("title", "login - Online Crime Reporting System");
		return "login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("title", "signup - Online Crime Reporting System");
		model.addAttribute("user", new User());
		return "signup";
	}

	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult bindingResult, @RequestParam(value = "agreement", defaultValue = "false") Boolean agreement,Model model, HttpSession session) {
		try {
			
			if (bindingResult.hasErrors()) {
				model.addAttribute("user", user);
				return "signup";
			}
			
			if (!agreement) {
				throw new Exception("You have not agreed the terms & conditions");
			}

			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setUser_imgurl("default.png");
			user.setUser_idcard_imgurl("default.png");
			user.setUser_passwd(passwordEncoder.encode(user.getUser_passwd()));


			//System.out.println("USER " + user);
			//System.out.println("agreement " + agreement);

			User result = this.userRepository.save(user);
			
			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Successfully Registered !!", "alert-success"));
			return "login";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Something Went wrong !!" + e.getMessage(), "alert-danger"));
			return "signup";
		}

	}
	
	@RequestMapping(value = "/officer_reg", method = RequestMethod.GET)
	public String officer_reg(Model model) {
		model.addAttribute("title", "signup - Online Crime Reporting System");
		model.addAttribute("user", new User());
		return "officer_reg";
	}
	
	@RequestMapping(value = "/officer_log", method = RequestMethod.GET)
	public String officer_log(Model model) {
		model.addAttribute("title", "Officer login - Online Crime Reporting System");
		return "officer_log";
	}
	
	@RequestMapping(value = "/officer_registration", method = RequestMethod.POST)
	public String registerOfficer(@Valid @ModelAttribute("user") User user,BindingResult bindingResult, @RequestParam(value = "agreement", defaultValue = "false") Boolean agreement,Model model, HttpSession session) {
		try {
			
			if (bindingResult.hasErrors()) {
				model.addAttribute("user", user);
				return "officer_reg";
			}
			
			if (!agreement) {
				throw new Exception("You have not agreed the terms & conditions");
			}

			user.setRole("ROLE_OFFICER");
			user.setEnabled(true);
			user.setUser_imgurl("default.png");
			user.setUser_idcard_imgurl("default.png");
			user.setUser_passwd(passwordEncoder.encode(user.getUser_passwd()));


			//System.out.println("USER " + user);
			//System.out.println("agreement " + agreement);

			User result = this.userRepository.save(user);
			
			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Successfully Registered !!", "alert-success"));
			return "officer_log";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Something Went wrong !!" + e.getMessage(), "alert-danger"));
			return "officer_reg";
		}

	}
}
