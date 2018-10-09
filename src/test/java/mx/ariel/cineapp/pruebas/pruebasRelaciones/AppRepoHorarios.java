package mx.ariel.cineapp.pruebas.pruebasRelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.model.Horario;
import mx.ariel.cineapp.repository.IHorariosRepository;

public class AppRepoHorarios {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		IHorariosRepository repo = context.getBean("iHorariosRepository", IHorariosRepository.class); 
		List<Horario> horarios =  repo.findAll(); 
		for (Horario horario : horarios) {
			System.out.println(horario);
		}
		context.close(); 

	}

}
