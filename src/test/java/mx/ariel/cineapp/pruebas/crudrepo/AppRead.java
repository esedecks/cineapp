package mx.ariel.cineapp.pruebas.crudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.model.Noticia;
import mx.ariel.cineapp.repository.INoticiasRepository;

public class AppRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		Noticia noticia = new Noticia(); 
		noticia.setId(3);
		INoticiasRepository noticiaRepository = context.getBean("noticiasRepository", INoticiasRepository.class); 
		Optional<Noticia> optional =  noticiaRepository.findById(noticia.getId());
		if(optional.isPresent())
			System.out.println("the movie is"+optional.get()); 
		else
			System.out.println("No se encuentra la pelicual");
		context.close();

	}

}
