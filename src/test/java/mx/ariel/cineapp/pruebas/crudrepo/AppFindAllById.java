package mx.ariel.cineapp.pruebas.crudrepo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.model.Noticia;
import mx.ariel.cineapp.repository.INoticiasRepository;

public class AppFindAllById {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); 
		INoticiasRepository repoNoticias = context.getBean("noticiasRepository", INoticiasRepository.class ); 
		List<Integer> ids = new ArrayList<>(); 
		ids.add(1); 
		ids.add(4); 
		ids.add(9); 
		
		Iterable<Noticia> it = repoNoticias.findAllById(ids); 
		for (Noticia noticia : it) {
			System.out.println(noticia);
			
		}
		
		context.close(); 
	}

}
