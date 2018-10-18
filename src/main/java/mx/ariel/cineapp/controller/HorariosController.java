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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.ariel.cineapp.model.Horario;
import mx.ariel.cineapp.model.Pelicula;
import mx.ariel.cineapp.service.IHorariosService;
import mx.ariel.cineapp.service.IPeliculasService;

@Controller
@RequestMapping("/horarios")
public class HorariosController {

	@Autowired
	IPeliculasService servicioPeliculas; 
	@Autowired
	IHorariosService horariosServices; 
	@GetMapping("/create")
	public String crear(@ModelAttribute("horario") Horario horario, Model model) {
		model.addAttribute("peliculas", servicioPeliculas.buscarTodas());
		return "horarios/formHorario"; 
	}
	
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		model.addAttribute("horarios", horariosServices.buscarTodos()); 
		return "horarios/listHorarios"; 
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
		horariosServices.insertar(horario);
		attributes.addFlashAttribute("mensaje", "Éxito al guardar el horario para la pelicula seleccionada");
		return "redirect:/horarios/index"; 
	}
	
	@GetMapping("/edit/{id}")
	public String modificar(@PathVariable("id") int idHorario , Model model) {
		model.addAttribute("horario", horariosServices.buscarPorId(idHorario));
		return "/horarios/formHorario"; 
	}
	
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idHorario , RedirectAttributes attributes ) {
		horariosServices.eliminar(idHorario);
		attributes.addFlashAttribute("mensaje", "Se eliminó el horario correctamente"); 
		
		return "redirect:/horarios/index"; 
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@ModelAttribute("peliculas")
	public List<Pelicula> obtenerPeliculas(){
		return servicioPeliculas.buscarTodas();
	}
	
	
}
