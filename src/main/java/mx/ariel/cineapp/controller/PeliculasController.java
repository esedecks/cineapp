package mx.ariel.cineapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.ariel.cineapp.model.Pelicula;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@GetMapping("/create")
	public String crear() {
		return "peliculas/formPelicula"; 
	}
	@PostMapping("/save")
	public String guardar(Pelicula pelicula, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("EXISTIERON ERRORES");
			for(ObjectError error: result.getAllErrors())
				System.out.println(error.getDefaultMessage());
			return "peliculas/formPelicula"; 
		}
		System.out.println("guardando pelicula "+pelicula);
		return "peliculas/formPelicula"; 
	}
}
