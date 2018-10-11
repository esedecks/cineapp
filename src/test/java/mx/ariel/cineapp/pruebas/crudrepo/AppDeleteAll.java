package mx.ariel.cineapp.pruebas.crudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.repository.INoticiasRepository;

public class AppDeleteAll {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); 
		
		INoticiasRepository repo = context.getBean("noticiasRepository", INoticiasRepository.class); 
		repo.deleteAll();
		
	}
}
