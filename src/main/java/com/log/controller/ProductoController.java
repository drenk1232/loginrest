package com.log.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.log.model.Producto;
import com.log.repository.ProductoRepository;

@Controller
@RequestMapping("/users")
public class ProductoController {
	
	private final Logger logg= LoggerFactory.getLogger(Producto.class);

	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("users", productoRepository.findAll());
		return "users";
	}
	
	@GetMapping("create")
	public String create() {
		return "create";
	}
	
	@PostMapping("/save")
	public String save(Producto producto) {
		logg.info("Informacion del objeto producto, {}", producto);
		productoRepository.save(producto);
		return "redirect:/users";
	}
}

