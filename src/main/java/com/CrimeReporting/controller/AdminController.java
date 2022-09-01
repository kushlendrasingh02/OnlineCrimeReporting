package com.CrimeReporting.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.CrimeReporting.dao.UserRepository;
import com.CrimeReporting.entities.User;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserRepository userRepository;
	
	@ModelAttribute
	public 	void addCommonData(Model model, Principal principal) {
		String userName = principal.getName();        
		User user = userRepository.getUserByUserName(userName);
		model.addAttribute("user",user);		
        model.addAttribute("title", "User Dashboard");
	}
	
	@RequestMapping("/index")
    public String dashboard(Model model, Principal principal) {
		
        return "admin/dashboard.html";
    }
}
