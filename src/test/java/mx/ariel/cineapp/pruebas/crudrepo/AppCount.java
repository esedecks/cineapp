package mx.ariel.cineapp.pruebas.crudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.repository.NoticiasRepository;

public class AppCount {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		NoticiasRepository repository = context.getBean("noticiasRepository", NoticiasRepository.class); 
		long count =  repository.count();
		System.out.println("número de registros son: "+count);
		context.close(); 
		
		
	}
}

