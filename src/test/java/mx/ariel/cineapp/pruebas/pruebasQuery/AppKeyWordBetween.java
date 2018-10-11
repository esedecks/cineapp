package mx.ariel.cineapp.pruebas.pruebasQuery;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.ariel.cineapp.model.Noticia;
import mx.ariel.cineapp.repository.INoticiasRepository;

public class AppKeyWordBetween {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); 
		INoticiasRepository repo = context.getBean("noticiasRepository", INoticiasRepository.class); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		Date fecha1 = new Date(), fecha2 = new Date(); 
		try {
			fecha1 = sdf.parse("2017-09-03");
			fecha2 = sdf.parse("2017-09-06"); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		List<Noticia> noticias = repo.findByFechaBetween(fecha1, fecha2);; 
		List<Noticia> noticias = repo.findByIdBetween(17, 20); 
		for (Noticia noticia : noticias) {
			System.out.println(noticia);
		}
		context.close();
	}

}
