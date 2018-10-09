package mx.ariel.cineapp.pruebas.pruebasRelaciones;




import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.model.Detalle;
import mx.ariel.cineapp.model.Pelicula;
import mx.ariel.cineapp.repository.IDetalleRepository;
import mx.ariel.cineapp.repository.IPeliculasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); 
		IPeliculasRepository repo = context.getBean("iPeliculasRepository", IPeliculasRepository.class); 
		List<Pelicula> peliculas = repo.findAll();
		for (Pelicula pelicula : peliculas) {
			System.out.println(pelicula);
		}
//		IDetalleRepository repo = context.getBean("iDetalleRepository", IDetalleRepository.class); 
//		List<Detalle> detalles = repo.findAll();
//		for (Detalle detalle : detalles) {
//			System.out.println(detalle);
//		}
		context.close();
	}

}
