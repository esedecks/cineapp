package mx.ariel.cineapp.pruebas.jparepo;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.repository.NoticiasRepository;

public class AppDeleteAllInBatch {
		/*Delete all in batch es un método más eficiente*/
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); 
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); 
		
		repo.deleteAllInBatch();
		context.close();
	}
}
