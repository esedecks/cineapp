package mx.ariel.cineapp.pruebas.crudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.repository.INoticiasRepository;

public class AppCount {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		INoticiasRepository repository = context.getBean("noticiasRepository", INoticiasRepository.class); 
		long count =  repository.count();
		System.out.println("número de registros son: "+count);
		context.close(); 
		
		
	}
}

