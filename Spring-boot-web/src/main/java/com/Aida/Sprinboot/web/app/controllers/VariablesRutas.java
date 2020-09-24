package com.Aida.Sprinboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/variables")
public class VariablesRutas {
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", "enviar parametros de la ruta(@PathVariable)");
		return "variables/index";
	}

	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("titulo", "recibir parametros de la ruta(@PathVariable)");
		model.addAttribute("resultado", "el texto enviado es: " + texto);
		return "variables/ver";
	}

	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto, @RequestParam Integer numero, Model model) {
		model.addAttribute("titulo", "recibir parametros de la ruta(@PathVariable)");
		model.addAttribute("resultado", "el texto enviado es: " + texto + "el numero recibi por el path es: " + numero);
		return "variables/ver";

	}

}
