package mx.ariel.cineapp.pruebas.crudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.repository.INoticiasRepository;

public class AppDelete {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		int id = 50; 
		INoticiasRepository repo = context.getBean("noticiasRepository", INoticiasRepository.class);
		if(repo.existsById(id))
			repo.deleteById(id);
		else 
			System.out.println("El objeto no existe");
		context.close(); 
		
	}
}
