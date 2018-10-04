package mx.ariel.cineapp.pruebas.crudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.repository.NoticiasRepository;

public class AppExist {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); 
		NoticiasRepository noticiasRepo = context.getBean("noticiasRepository", NoticiasRepository.class); 
		/*Método para verificar si objeto existe en la base de datos*/
		int idNoticia = 3; 
		System.out.println(noticiasRepo.existsById(idNoticia)); 
		
		context.close(); 

	}

}
