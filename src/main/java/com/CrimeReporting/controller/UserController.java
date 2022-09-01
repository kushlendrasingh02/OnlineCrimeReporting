package com.CrimeReporting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.CrimeReporting.dao.CasefileRepository;
import com.CrimeReporting.dao.UserRepository;
import com.CrimeReporting.entities.Casefile;
import com.CrimeReporting.entities.User;
import com.CrimeReporting.helper.Message;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.awt.Dialog.ModalExclusionType;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		model.addAttribute("user", user);
		model.addAttribute("title", "User Dashboard");
	}

	@RequestMapping("/index")
	public String dashBoard(Model model, Principal principal) {

		return "normal/user_dashboard";
	}

	@GetMapping("/fir")
	public String fir(Model model) {
		model.addAttribute("title", "FIR - Online Crime Reporting System");
		model.addAttribute("casefile", new Casefile());
		return "normal/fir";
	}

	@RequestMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("title", "Contact - Online Crime Reporting System");
		return "normal/contact";
	}

	@RequestMapping("/blog")
	public String blog(Model model) {
		model.addAttribute("title", "blog - Online Crime Reporting System");
		return "normal/blog";
	}

	@PostMapping("/processFirReg")
	public String processContact(@ModelAttribute Casefile casefile, @RequestParam("proof") MultipartFile multipartFile,
			BindingResult bindingResult, Model model, Principal principal, HttpSession session) {

		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("casefile", casefile);
				return "normal/fir";
			}

			String userName = principal.getName();
			User user = this.userRepository.getUserByUserName(userName);
			if (multipartFile.isEmpty()) {
				//
				System.out.println("File not Uploaded");
				model.addAttribute("casefile", casefile);
				session.setAttribute("message", new Message("Please Select a Photo", "alert-danger"));
				return "normal/fir";

			} else {
				casefile.setAvidence_pic(multipartFile.getOriginalFilename());
				File saveFile = new ClassPathResource("static/images").getFile();
				Path path = Paths
						.get(saveFile.getAbsolutePath() + File.separator + multipartFile.getOriginalFilename());
				Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("File is Uploaded");
			}
			casefile.setUser(user);
			casefile.setFir_status("Pending");
			user.getCasefiles().add(casefile);
			this.userRepository.save(user);
			System.out.println("Data: " + casefile);
			model.addAttribute("casefile", new Casefile());

			/* Message Success */
			session.setAttribute("message", new Message("Contact added Successfully!!", "alert-success"));

			return "normal/fir";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("casefile", casefile);
			session.setAttribute("message", new Message("Something went wrong " + e.getMessage(), "alert-danger"));
		}
		return "normal/fir";
	}
	
	@GetMapping("/profile")
	public String myProfile(Model model) {
		model.addAttribute("title","Profile Page");
		return "normal/profile";
	}
}
