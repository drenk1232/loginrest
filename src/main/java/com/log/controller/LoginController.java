package com.log.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.log.model.Credenciales;

@Controller
public class LoginController {
	
	
	@GetMapping("/login")
	public String Login(Model model, @RequestParam(required=false, name="error") String error) {
		model.addAttribute("error", error);
		model.addAttribute("credenciales", new Credenciales());
		
		return "login";	
	}
	
	@PostMapping("/users")
	public String Check(@ModelAttribute(name="credenciales")Credenciales credenciales) {
		if(credenciales.getUser().equals("paco@es.es") && credenciales.getPass().equals("234")) {
			return "users";
		}
		else {
			return "redirect:/login?error";
		}
	}
	
	
	
}