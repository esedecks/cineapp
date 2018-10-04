package mx.ariel.cineapp.pruebas.crudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.model.Noticia;
import mx.ariel.cineapp.repository.NoticiasRepository;

public class AppCreate {

	public static void main(String[] args) {
		Noticia noticia = new Noticia(); 
		noticia.setTitulo("El rey leon");
		noticia.setDetalle("El estreno del año es para Alfa :D");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); 
		NoticiasRepository repoNoticias = context.getBean("noticiasRepository", NoticiasRepository.class ); 
		repoNoticias.save(noticia); 
		context.close(); 

	}

}
