package mx.ariel.cineapp.pruebas.crudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.model.Noticia;
import mx.ariel.cineapp.repository.INoticiasRepository;

public class AppCreate {

	public static void main(String[] args) {
		Noticia noticia = new Noticia(); 
		noticia.setTitulo("El rey leon");
		noticia.setDetalle("El estreno del año es para Alfa :D");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); 
		INoticiasRepository repoNoticias = context.getBean("noticiasRepository", INoticiasRepository.class ); 
		repoNoticias.save(noticia); 
		context.close(); 

	}

}
