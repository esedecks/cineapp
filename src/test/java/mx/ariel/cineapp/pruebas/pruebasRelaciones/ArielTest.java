package mx.ariel.cineapp.pruebas.pruebasRelaciones;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ArielTest {

	public static void main(String[] args) throws Exception {
        GregorianCalendar dateOut = new GregorianCalendar();
        Calendar cal = Calendar.getInstance();
        Date fechaCalc = new Date();
        dateOut.add(Calendar.DAY_OF_YEAR, 23);
        String fechaCad = dateToString(dateOut.getTime(),"yyyy-MM-dd");
        System.out.	println(fechaCad);
	}
	
	public static String dateToString(Date fecha, String formato) throws Exception {
		   String date = null;
		   try {
			   date = (new SimpleDateFormat(formato)).format(fecha); 
		   } catch ( Exception e ) {
			   throw new Exception(e.toString());
		   }
		   return date;
	   }
}
