package mx.ariel.cineapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mx.ariel.cineapp.model.Detalle;
import mx.ariel.cineapp.model.Horario;
import mx.ariel.cineapp.model.Pelicula;
import mx.ariel.cineapp.service.IBannersService;
import mx.ariel.cineapp.service.IHorariosService;
import mx.ariel.cineapp.service.IPeliculasService;
import mx.ariel.cineapp.util.Utileria;
@Controller
public class HomeController {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	@Autowired
	IPeliculasService servicioPeliculas; 
	// Ejercicio: Inyectar clase de servicio de Banners
	@Autowired
	IBannersService bannerServices ; 
	@Autowired
	IHorariosService horariosServices ; 
	@GetMapping(value="/")
//	@RequestMapping(value="/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		List<Pelicula> peliculas = servicioPeliculas.buscarTodas(); 
		model.addAttribute("peliculas", peliculas); 
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		List<String> listaFechas = Utileria.getNextDays(5); 
		model.addAttribute("fechas", listaFechas); 
//		System.out.println("Lista fechas "+listaFechas);
		// Ejercicio: agregar al modelo el listado de Banners para desplegarlo
		model.addAttribute("bannerList", bannerServices.buscarTodos()); 
		
		return "home";
	}
	
	@PostMapping(value="/search")
//	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(Model model, @RequestParam("fecha")String fecha) {
		System.out.println("Buscando todas las peliculas en exhibición para la fecha: "+fecha);
		List<Pelicula> peliculas = servicioPeliculas.buscarTodas(); 
		model.addAttribute("peliculas", peliculas); 
		model.addAttribute("fechaBusqueda", fecha);
		List<String> listaFechas = Utileria.getNextDays(5); 
		model.addAttribute("fechas", listaFechas); 
		// Ejercicio: agregar al modelo el listado de Banners para desplegarlo
		model.addAttribute("bannerList", bannerServices.buscarTodos());
		return "home";
	}
	
//	@RequestMapping(value="/detail/{id}/{fecha}", method = RequestMethod.GET)
	@RequestMapping(value="/detail", method = RequestMethod.GET)
//	public String mostrarDetalle(@PathVariable("id") int id,@PathVariable("fecha")String fecha, Model model) {
	public String mostrarDetalle(@RequestParam("idMovie")int id,@RequestParam("fecha")Date fecha, Model model) {
		/*Buscar en la base de datos*/
		List<Horario> horarios = horariosServices.buscarPorIdPelicula(id, fecha);
		model.addAttribute("pelicula", servicioPeliculas.buscarPorId(id));
		model.addAttribute("horarios", horarios);
		model.addAttribute("fechaBusqueda", dateFormat.format(fecha));
		return"detalle"; 
		
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	

}
