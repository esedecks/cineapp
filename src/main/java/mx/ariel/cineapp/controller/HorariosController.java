package mx.ariel.cineapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.ariel.cineapp.model.Horario;
import mx.ariel.cineapp.service.IPeliculasService;

@Controller
@RequestMapping("/horarios")
public class HorariosController {

	@Autowired
	IPeliculasService servicioPeliculas; 
	
	@GetMapping("/create")
	public String crear(@ModelAttribute("horario") Horario horario, Model model) {
		model.addAttribute("peliculas", servicioPeliculas.buscarTodas());
		return "horarios/formHorario"; 
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute("horario") Horario horario, 
						BindingResult bindingResult, 
						RedirectAttributes attributes, 
						Model model) {
		
		System.out.println(horario);
		if(bindingResult.hasErrors()) {
			model.addAttribute("peliculas", servicioPeliculas.buscarTodas());
			System.out.println("Sucedieron errores al intentar guardar el horario");
			for(ObjectError e : bindingResult.getAllErrors()) {
				System.out.println(e.getDefaultMessage());
			}
			return "/horarios/formHorario"; 
		}
		
		System.out.println("Se guarda el objeto horario");
		
		attributes.addFlashAttribute("mensaje", "Éxito al guardar el horario para la pelicula seleccionada");
		
		return "redirect:/horarios/create"; 
//		return "/horarios/formHorario"; 
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	
}
