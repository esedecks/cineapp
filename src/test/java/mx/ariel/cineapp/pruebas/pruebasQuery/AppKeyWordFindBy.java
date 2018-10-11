package mx.ariel.cineapp.pruebas.pruebasQuery;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.model.Noticia;
import mx.ariel.cineapp.repository.INoticiasRepository;

public class AppKeyWordFindBy {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); 
		INoticiasRepository repo = context.getBean("noticiasRepository", INoticiasRepository.class); 
//		List<Noticia> lista = repo.findByEstatus("Inactiva"); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		Date fecha = new Date(); 
		try {
			fecha = sdf.parse("2017-09-08");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		List<Noticia> lista = repo.findByFecha(fecha); 
		for (Noticia noticia : lista) {
			System.out.println(noticia);
		}
		context.close();
	}

}
