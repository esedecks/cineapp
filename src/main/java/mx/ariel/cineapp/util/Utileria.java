package mx.ariel.cineapp.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
}
