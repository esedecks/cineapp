package mx.ariel.cineapp.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {
	
	public static List<String> getNextDays(int count) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date start = new Date(); 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, count);
		Date enDate = calendar.getTime();
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);
		List<String> nextDays = new ArrayList<>(); 
		while(!gcal.getTime().after(enDate)) {
				Date d = gcal.getTime();
				gcal.add(Calendar.DATE,1);
				nextDays.add(sdf.format(d));
		}
		return nextDays;
	}
	
	public static String guardarImagen(MultipartFile multipart, HttpServletRequest request) {
		String nombreOriginal = multipart.getOriginalFilename().replace(" ", "-");
		String nombreFinal = randomAlphaNumeric(8)+nombreOriginal; 
		String pathDestino = request.getServletContext().getRealPath("/resources/images/");
		
		try {
			File file = new File(pathDestino+nombreFinal);
			System.out.println("PATH DE LA IMAGEN "+file.getAbsolutePath());
			multipart.transferTo(file);
			return nombreFinal; 
		}catch(IOException ioe) {
			ioe.printStackTrace();
			return null; 
		}
	}
	
	public static String randomAlphaNumeric(int count) {
		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; 
		StringBuilder sb = new StringBuilder();
		while(count-- != 0) {
			int character = (int)(Math.random()*CARACTERES.length()); 
			sb.append(CARACTERES.charAt(character)) ;
		}
		return sb.toString() ;
		
		
	}
}
