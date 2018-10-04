package mx.ariel.cineapp.pruebas.crudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.model.Noticia;
import mx.ariel.cineapp.repository.NoticiasRepository;

public class AppUpdate {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository noticiaRepository = context.getBean("noticiasRepository", NoticiasRepository.class);
		Optional<Noticia> optional = noticiaRepository.findById(2); 
		
		if(!optional.isPresent()) {
			System.out.println("El objeto no se encuentra");
			context.close(); 
			return ; 
		}
		
		Noticia noticiaToUpdate = optional.get(); 
		noticiaToUpdate.setTitulo("Spider man Home coming");
		noticiaToUpdate.setStatus("Inactiva");
		noticiaToUpdate.setDetalle("La pelicula de la araña  se repite nuevamente :d");
		
		System.out.println("Actualizando objeto noticia");
		noticiaRepository.save(noticiaToUpdate);
		System.out.println("Se actualizó correctamente");
		context.close();
	}

}

