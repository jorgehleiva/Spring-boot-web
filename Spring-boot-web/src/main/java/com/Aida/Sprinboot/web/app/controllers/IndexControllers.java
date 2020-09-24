package com.Aida.Sprinboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Aida.Sprinboot.web.app.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexControllers {
	
	@Value("${texto.indexcontroller.index.titulo:}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo:}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo:}")
	private String textoListar;

	
	@GetMapping({"/index","/","","/home"}) 
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario=new Usuario();
		usuario.setNombre("jorge");
		usuario.setApellido("leiva");
		usuario.setEmail("jorge_leiva@hotmail.com");
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo",textoPerfil.concat(usuario.getNombre()));
		return "perfil";
		
	}
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo",textoListar);
		return "listar";
		
	}
	@ModelAttribute("usuarios")
	public List<Usuario>poblarUsuarios(){
	List<Usuario> usuarios=new ArrayList<>();
		
		usuarios.add(new Usuario("jorge","leiva","jorge_leiva@hotmail.com"));
		usuarios.add(new Usuario("mary","chavez","jorge_leiva@hotmail.com"));
		usuarios.add(new Usuario("leo","leiva","jorge_leiva@hotmail.com"));
		usuarios.add(new Usuario("benja","leiva","jorge_leiva@hotmail.com"));
		
		return usuarios;
		
		
	}
	
}
