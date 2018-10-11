package mx.ariel.cineapp.pruebas.jparepo;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.repository.INoticiasRepository;

public class AppDeleteAllInBatch {
		/*Delete all in batch es un método más eficiente*/
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); 
		INoticiasRepository repo = context.getBean("noticiasRepository", INoticiasRepository.class); 
		
		repo.deleteAllInBatch();
		context.close();
	}
}
