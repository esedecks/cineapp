package mx.ariel.cineapp.pruebas.jparepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import mx.ariel.cineapp.model.Noticia;
import mx.ariel.cineapp.repository.INoticiasRepository;

public class AppPagingAndSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); 
		INoticiasRepository repo = context.getBean("noticiasRepository", INoticiasRepository.class); 
		/*Obtener registros por ordenamiento*/
//		List<Noticia> noticiasList = repo.findAll(Sort.by("titulo").descending());
//		List<Noticia> noticiasList = repo.findAll(Sort.by("fecha").descending().and(Sort.by("titulo").ascending()));
//		List<Noticia> noticiasList = repo.findAll(
//												Sort.by("fecha").descending()
//													.and(
//												Sort.by("titulo").ascending()));
		
//		Page<Noticia> pages =  repo.findAll(PageRequest.of( 2, 10 ));
		
		Page<Noticia> pages = repo.findAll(PageRequest.of(0, 10, Sort.by("titulo").ascending()));
		for (Noticia noticia : pages) {
			System.out.println(noticia);
		}
//		for (Noticia noticia : noticiasList) {
//			System.out.println(noticia);
//		}
		
		context.close();
	}

}
