package mx.ariel.cineapp.controller;

import java.text.ParseException;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import mx.ariel.cineapp.model.Banner;
import mx.ariel.cineapp.model.Horario;
import mx.ariel.cineapp.model.Noticia;
import mx.ariel.cineapp.model.Pelicula;
import mx.ariel.cineapp.service.IBannersService;
import mx.ariel.cineapp.service.IHorariosService;
import mx.ariel.cineapp.service.INoticiasService;
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
	@Autowired
	INoticiasService noticiasServices; 
	
	@GetMapping(value="/")
//	@RequestMapping(value="/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		System.out.println("horarios test");
		try {
			Date fechaSinHora = dateFormat.parse(dateFormat.format(new Date())); 
			List<Pelicula> peliculas = servicioPeliculas.buscarPorFechaYestatus(fechaSinHora, "Activa"); 
			model.addAttribute("peliculas", peliculas); 
			model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		}catch(ParseException exception ) {
			System.out.println("Error: HomeController.mostrarPrincipal "+ exception.getMessage());
		}	
		return "home";
	}
	
	@PostMapping(value="/search")
//	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(Model model, @RequestParam("fecha")String fecha) {
		System.out.println("Buscando todas las peliculas en exhibición para la fecha: "+fecha);
//		List<Pelicula> peliculas = servicioPeliculas.buscarTodas();
		try {
			List<Pelicula> peliculas = servicioPeliculas.buscarPorFechaYestatus(dateFormat.parse(fecha), "Activa");
			model.addAttribute("peliculas", peliculas); 
			model.addAttribute("fechaBusqueda", fecha);
		}catch(ParseException exception) {
			System.out.println("Error: HomeController.buscar() "+exception.getMessage());
		}
		
//		List<String> listaFechas = Utileria.getNextDays(5); 
//		model.addAttribute("fechas", listaFechas); 
		// Ejercicio: agregar al modelo el listado de Banners para desplegarlo
//		model.addAttribute("bannerList", bannerServices.buscarTodos());
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
	
	@ModelAttribute("bannerList")
	public List<Banner> obtenerBanners(){
		return bannerServices.buscarActivos();
		
	}
	
	@ModelAttribute("fechas")
	public List<String> obtenerSiguientesFechas(){
		return Utileria.getNextDays(5); 
	}
	
	@ModelAttribute("noticias")
	public List<Noticia> obtenerNoticias(){
		/*Agregar las últimas 3 noticias activas*/
		return noticiasServices.obtenerUltimasNoticias();
	}
	
	@GetMapping(value="/about")
	public String mostrarAcerca() {
		return "acerca";
	}
	
	@GetMapping(value="/formLogin")
	public String mostrarLogin() {
		return "formLogin";
	}
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	

}
