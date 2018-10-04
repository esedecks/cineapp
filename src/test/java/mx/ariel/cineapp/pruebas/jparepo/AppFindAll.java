package mx.ariel.cineapp.pruebas.jparepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.model.Noticia;
import mx.ariel.cineapp.repository.NoticiasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); 
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); 
		
		List<Noticia> noticias = repo.findAll(); 
		for (Noticia noticia : noticias) {
			System.out.println(noticia);
		}
		context.close();
	}

}
