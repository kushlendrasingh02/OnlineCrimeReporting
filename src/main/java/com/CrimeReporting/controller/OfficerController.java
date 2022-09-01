package com.CrimeReporting.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.CrimeReporting.dao.CasefileRepository;
import com.CrimeReporting.dao.UserRepository;
import com.CrimeReporting.entities.Casefile;
import com.CrimeReporting.entities.User;
import com.CrimeReporting.helper.Message;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

@Controller
@RequestMapping("/officer")
public class OfficerController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CasefileRepository casefileRepository;

	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		model.addAttribute("user", user);
		model.addAttribute("title", "Officer Dashboard");
	}

	@RequestMapping("/index")
	public String dashboard(Model model, Principal principal) {

		return "officer/dashboard.html";
	}

	@GetMapping("/firTable/{page}")
	public String firTable(@PathVariable("page") Integer page, Model model) {
		model.addAttribute("title", "All FIR Registered");
		Pageable pageable = PageRequest.of(page, 5);
		Page<Casefile> casefiles = this.casefileRepository.findAllCasefiles(pageable);
		model.addAttribute("casefiles", casefiles);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPage", casefiles.getTotalPages());
		return "officer/firTable";
	}

	@GetMapping("/firView/{casefile_id}")
	public String firView(@PathVariable("casefile_id") Integer casefile_id, Model model) {
		model.addAttribute("title", "View FIR Registered");
		Optional<Casefile> casefile = this.casefileRepository.findById(casefile_id);
		Casefile casefile2 = casefile.get();
		model.addAttribute("casefile", casefile2);
		return "officer/firView";
	}

	@GetMapping("/firUpdate/{casefile_id}")
	public String firUpdate(@PathVariable("casefile_id") Integer casefile_id, Model model) {
		model.addAttribute("title", "Update FIR Registered");
		Casefile casefile = this.casefileRepository.getById(casefile_id);
		model.addAttribute("casefile", casefile);
		return "officer/firUpdate";
	}

	@GetMapping("/delete/{casefile_id}")
	public String deleteContact(@PathVariable("casefile_id") Integer casefile_id) {
		Optional<Casefile> casefileOptional = this.casefileRepository.findById(casefile_id);
		Casefile casefile = casefileOptional.get();
		this.casefileRepository.delete(casefile);
		return "redirect:/officer/firTable/0";
	}

	@RequestMapping(value = "/process-update", method = RequestMethod.POST)
	public String updateFir(@ModelAttribute Casefile casefile, @RequestParam("proof") MultipartFile multipartFile,
			BindingResult bindingResult, Model model, Principal principal, HttpSession session) {
		try {
			Casefile oldDetails = this.casefileRepository.findById(casefile.getCasefile_id()).get();
			if (!multipartFile.isEmpty()) {
				File deleteFile = new ClassPathResource("static/images").getFile();
				File file1 = new File(deleteFile,oldDetails.getAvidence_pic());
				file1.delete();
				File saveFile = new ClassPathResource("static/images").getFile();
				Path path = Paths
						.get(saveFile.getAbsolutePath() + File.separator + multipartFile.getOriginalFilename());
				Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				casefile.setAvidence_pic(multipartFile.getOriginalFilename());
			} else {
				casefile.setAvidence_pic(oldDetails.getAvidence_pic());
			}
			casefile.setUser(oldDetails.getUser());
			this.casefileRepository.save(casefile);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		session.setAttribute("message", new Message("Your contact is updated...", "alert-success"));
		return "redirect:/officer/firView/"+casefile.getCasefile_id();
	}

}
