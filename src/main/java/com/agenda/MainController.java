package com.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@Autowired
	ContactoService repo;

	@GetMapping("/contactos/create")
	public String mostrarFormularioContacto(@ModelAttribute("Contacto") Contacto contacto) {
		return "contactos/create";
	}

	@PostMapping("/contactos/create")
	public String crearContacto(@ModelAttribute("Contacto") Contacto contacto) {
		repo.save(contacto);
		return "redirect:/";
	}

	@GetMapping("/")
	public ModelAndView paginaInicial() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("contactos", repo.findAll());
		return mav;
	}

	@GetMapping("/delete/{id}")
	public String borrarUno(@PathVariable("id") Long id) {
		Contacto c = repo.findById(id);
		repo.delete(c);
		return "redirect:/";
	}

	@GetMapping("/update/{id}")
	public String mostrarFormActualizar(@PathVariable("id") Long id, Model model) {
		Contacto c = repo.findById(id);
		model.addAttribute("Contacto", c);
		return "contactos/update";
	}

	@PostMapping("/update/{id}")
	public String actualizarUno(@PathVariable("id") Long id, Model model,
			@ModelAttribute("Contacto") Contacto contacto) {
		repo.save(contacto);
		return "redirect:/";
	}

}
