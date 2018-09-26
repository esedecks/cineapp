package mx.ariel.cineapp.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.ariel.cineapp.model.Pelicula;
import mx.ariel.cineapp.service.IPeliculasService;
import mx.ariel.cineapp.util.Utileria;

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
	public String crear(@ModelAttribute("pelicula") Pelicula pelicula, Model model) {
		model.addAttribute("generos",peliculaService.buscarGeneros() );
		return "peliculas/formPelicula"; 
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute("pelicula")Pelicula pelicula, 
					BindingResult result, 
					RedirectAttributes attributes, 
					@RequestParam("archivoImagen") MultipartFile multipart, 
					HttpServletRequest request) {
		
		if(result.hasErrors()) {
			System.out.println("Exiten errores");
			for(ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "peliculas/formPelicula"; 
		}
		String nombreImagen ="" ;
		if(!multipart.isEmpty()) {
			nombreImagen = Utileria.guardarImagen(multipart, request);
			pelicula.setImagen(nombreImagen);
		}
		System.out.println("guardando pelicula "+pelicula);
		peliculaService.insertar(pelicula);
		attributes.addFlashAttribute("mensaje","La pelicula se guardo con éxito");
		return "redirect:/peliculas/index"; 
	}
	
	@GetMapping ("/index")
	public String mostrarIndex(Model model) {
		List<Pelicula> listaPeliculas = peliculaService.buscarTodas();
		model.addAttribute("peliculas", listaPeliculas); 
		return "peliculas/listPeliculas"; 
	}
}
