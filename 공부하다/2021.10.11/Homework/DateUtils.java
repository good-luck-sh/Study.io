package homework;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 d일 H시");
	
	public static Date stringToDate(String str) {
		try {
			if (str == null) {
				return null;
			}
			if (str.trim().isEmpty()) {
				return null;
			}
			return sdf.parse(str);
		} catch (ParseException ex) {
			return null;
		}
	}
	
	public static String dateToString(Date date) {
		if (date == null) {
			return "";
		}
		return sdf.format(date);
	}
}
