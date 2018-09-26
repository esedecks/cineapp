package mx.ariel.cineapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import mx.ariel.cineapp.model.Contacto;
import mx.ariel.cineapp.service.IPeliculasService;

@Controller
public class ContactoController {
	
	@Autowired
	IPeliculasService peliculaService; 
	@GetMapping("/contacto")
	public String mostrarFormulario (@ModelAttribute("contacto") Contacto contacto, Model model) {
		model.addAttribute("generos", peliculaService.buscarGeneros());
		model.addAttribute("notificaciones", tipoNotificaciones()); 
		
		return "formContacto"; 
	}
	
	@PostMapping("/contacto")
	public String guardar(@ModelAttribute("contacto") Contacto contacto, Model model) {
//		model.addAttribute("generos", peliculaService.buscarGeneros());
//		model.addAttribute("notificaciones", tipoNotificaciones()); 
		System.out.println(contacto);
		return "redirect:/contacto";
		
	}
	
	private List<String> tipoNotificaciones(){
		List<String> tipos = new ArrayList<>(); 
		tipos.add("Estrenos");
		tipos.add("Promociones"); 
		tipos.add("Noticias"); 
		tipos.add("Preventas"); 
		return tipos; 
		
		
		
	}
}
