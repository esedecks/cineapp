package mx.ariel.cineapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.ariel.cineapp.model.Noticia;
import mx.ariel.cineapp.service.INoticiasService;

@Controller
@RequestMapping(value="/noticias")
public class NoticiasController {
	
	@Autowired
	INoticiasService noticiasService; 
	
	@GetMapping(value="/create")
	public String crear() {
		return "noticias/formNoticia"; 
	}
	
	@PostMapping(value="/save")
	public String guardar(@RequestParam("titulo")String titulo, 
						 @RequestParam("estatus")String estatus, 
						 @RequestParam("detalle")String detalle,
						 Model model) {
		Noticia noticia = new Noticia();
		
		noticia.setTitulo(titulo);
		noticia.setStatus(estatus);
		noticia.setDetalle(detalle);
		/*GUARDAR EL OBJETO NOTICIA EN LA BASE DE DATOS*/
//		System.out.println("Objeto noticia "+noticia);
		noticiasService.guardar(noticia);
		return "noticias/formNoticia";
	}
}

