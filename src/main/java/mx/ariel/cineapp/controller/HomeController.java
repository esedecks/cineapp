package mx.ariel.cineapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mx.ariel.cineapp.model.Pelicula;
import mx.ariel.cineapp.util.Utileria;
@Controller
public class HomeController {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@GetMapping(value="/")
//	@RequestMapping(value="/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		List<Pelicula> peliculas = getLista(); 
		model.addAttribute("peliculas", peliculas); 
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		List<String> listaFechas = Utileria.getNextDays(5); 
		model.addAttribute("fechas", listaFechas); 
//		System.out.println("Lista fechas "+listaFechas);
		return "home";
	}
	@PostMapping(value="/search")
//	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(Model model, @RequestParam("fecha")String fecha) {
		System.out.println("Buscando todas las peliculas en exhibición para la fecha: "+fecha);
		List<Pelicula> peliculas = getLista(); 
		model.addAttribute("peliculas", peliculas); 
		model.addAttribute("fechaBusqueda", fecha);
		List<String> listaFechas = Utileria.getNextDays(5); 
		model.addAttribute("fechas", listaFechas); 
		return "home";
	}
	
//	@RequestMapping(value="/detail/{id}/{fecha}", method = RequestMethod.GET)
	@RequestMapping(value="/detail", method = RequestMethod.GET)
//	public String mostrarDetalle(@PathVariable("id") int id,@PathVariable("fecha")String fecha, Model model) {
	public String mostrarDetalle(@RequestParam("idMovie")int id,@RequestParam("fecha")String fecha, Model model) {
		System.out.println("idPelicula "+id);
		System.out.println("Buscando horarios para la fecha"+fecha);
//		List<Pelicula> peliculas = getLista(); 
//		model.addAttribute("peliculas", peliculas); 
		/*Buscar en la base de datos*/
		return"detalle"; 
		
	}
	
	// Metodo para generar una lista de Objetos de Modelo (Pelicula)
		private List<Pelicula> getLista() {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			List<Pelicula> lista = null;
			try {
				lista = new LinkedList<>();

				Pelicula pelicula1 = new Pelicula();
				pelicula1.setId(1);
				pelicula1.setTitulo("Power Rangers");
				pelicula1.setDuracion(120);
				pelicula1.setClasificacion("B");
				pelicula1.setGenero("Aventura");
				pelicula1.setFechaEstreno(formatter.parse("02-05-2017"));
				// imagen="cinema.png"
				// estatus="Activa"

				Pelicula pelicula2 = new Pelicula();
				pelicula2.setId(2);
				pelicula2.setTitulo("La bella y la bestia");
				pelicula2.setDuracion(132);
				pelicula2.setClasificacion("A");
				pelicula2.setGenero("Infantil");
				pelicula2.setFechaEstreno(formatter.parse("20-05-2017"));
				pelicula2.setImagen("bella.png"); // Nombre del archivo de imagen

				Pelicula pelicula3 = new Pelicula();
				pelicula3.setId(3);
				pelicula3.setTitulo("Contratiempo");
				pelicula3.setDuracion(106);
				pelicula3.setClasificacion("B");
				pelicula3.setGenero("Thriller");
				pelicula3.setFechaEstreno(formatter.parse("28-05-2017"));
				pelicula3.setImagen("contratiempo.png"); // Nombre del archivo de imagen

				Pelicula pelicula4 = new Pelicula();
				pelicula4.setId(4);
				pelicula4.setTitulo("Kong La Isla Calavera");
				pelicula4.setDuracion(118);
				pelicula4.setClasificacion("B");
				pelicula4.setGenero("Accion y Aventura");
				pelicula4.setFechaEstreno(formatter.parse("06-06-2017"));
				pelicula4.setImagen("kong.png"); // Nombre del archivo de imagen
				pelicula4.setEstatus("Inactiva"); // Esta pelicula estara inactiva
				
				
				Pelicula pelicula5 = new Pelicula();
				pelicula5.setId(5);
				pelicula5.setTitulo("Life: Vida inteligente");
				pelicula5.setDuracion(120);
				pelicula5.setClasificacion("B");
				pelicula5.setGenero("Acción y acentrura");
				pelicula5.setFechaEstreno(formatter.parse("06-06-2017"));
				pelicula5.setImagen("estreno5.png"); // Nombre del archivo de imagen
				pelicula5.setEstatus("Activa"); // Esta pelicula estara inactiva
				// Agregamos los objetos Pelicula a la lista
				lista.add(pelicula1);
				lista.add(pelicula2);
				lista.add(pelicula3);
				lista.add(pelicula4);
				lista.add(pelicula5);

				return lista;
			} catch (ParseException e) {
				System.out.println("Error: " + e.getMessage());
				return null;
			}
		}

}
