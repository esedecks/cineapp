package mx.ariel.cineapp.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.ariel.cineapp.model.Pelicula;
import mx.ariel.cineapp.service.IPeliculasService;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
	@Autowired
	IPeliculasService peliculaService; 
	
	/*Permite crear métodos para configuar el data binding directamente en el controlador*/
	@InitBinder
	public void initBindinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		/*El false es para indicar que las fechas no estén vacias */
	}
	
	@GetMapping("/create")
	public String crear() {
		return "peliculas/formPelicula"; 
	}
	
	@PostMapping("/save")
	public String guardar(Pelicula pelicula, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("Exiten errores");
			for(ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "peliculas/formPelicula"; 
		}
		System.out.println("guardando pelicula "+pelicula);
		peliculaService.insertar(pelicula);
		return "peliculas/formPelicula"; 
	}
	
	@GetMapping ("/index")
	public String mostrarIndex(Model model) {
		List<Pelicula> listaPeliculas = peliculaService.buscarTodas();
		model.addAttribute("peliculas", listaPeliculas); 
		return "peliculas/listPeliculas"; 
	}
}
