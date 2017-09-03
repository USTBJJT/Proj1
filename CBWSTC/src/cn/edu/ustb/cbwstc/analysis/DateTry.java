package cn.edu.ustb.cbwstc.analysis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		compareDate("2017-08-14");
		addDate(new Date());
	}
	
	/**
	 * 
	 * @param dateStr
	 */
	public static Date stringToDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date date = new Date();
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public static void compareDate(String dateStr) {
		Date now = new Date();
		System.out.println(stringToDate(dateStr));
		if(now.before(stringToDate(dateStr))) {
			System.out.println("now is small than Date");
		}else {
			System.out.println("now is big than Date");
		}
	}
	
	public static void addDate(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DATE, 1);
		System.out.println(cal.getTime());
	}
	

}
