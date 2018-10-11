package mx.ariel.cineapp.pruebas.pruebasRelaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.model.Pelicula;
import mx.ariel.cineapp.repository.IPeliculasRepository;

public class AppGetHorariosPelicula {
	public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); 
		IPeliculasRepository repo = context.getBean("iPeliculasRepository", IPeliculasRepository.class); 
		Optional<Pelicula> peliculas = repo.findById(1); 
		System.out.println(peliculas.get().getHorarios().size());
		context.close();
	}
}
