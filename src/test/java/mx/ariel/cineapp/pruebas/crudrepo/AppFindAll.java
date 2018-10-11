package mx.ariel.cineapp.pruebas.crudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.model.Noticia;
import mx.ariel.cineapp.repository.INoticiasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		INoticiasRepository repo = context.getBean("noticiasRepository", INoticiasRepository.class); 
		System.out.println("Leyendo noticias");
		Iterable<Noticia> it =  repo.findAll();
		System.out.println("Se leyearon correctamente las noticias");
		for(Noticia n: it) {
			System.out.println(n);
		}
	}

}
