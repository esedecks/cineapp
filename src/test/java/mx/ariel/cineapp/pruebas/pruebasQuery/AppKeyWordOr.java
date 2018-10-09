package mx.ariel.cineapp.pruebas.pruebasQuery;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.model.Noticia;
import mx.ariel.cineapp.repository.NoticiasRepository;

public class AppKeyWordOr {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); 
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		Date fecha = new Date(); 
		try {
			fecha = sdf.parse("2017-10-08");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String estatus = "Inactiva"; 
		List<Noticia> noticias = repo.findByEstatusOrFecha(estatus, fecha); 
		for (Noticia noticia : noticias) {
			System.out.println(noticia);
		}
		context.close();
	}

}
