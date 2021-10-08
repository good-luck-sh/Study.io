package example_10_08_formating;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatSample2 {

	public static void main(String[] args) throws ParseException {
		
		//오늘 
		Date today = new Date();
		
		//문자를 Date로 변경하는 것, 내가 태어난 날
		String text1 = "2021-10-08";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 변경하고싶은 것과 동일하게 만들어야함
		Date birthday = sdf.parse(text1);//에러가 남, main으로 throws parseException으로 다시 던짐
		
		//System.out.println(date);
		//DateFormat의 역활
		//1.날짜를 원하는 text를 변환하는 법
		//2.지정된 패턴을 읽어서 Date객체로 만드는 법
		
		long todayUnixTime = today.getTime();
		long birthdayUnixTime = birthday.getTime();
		
		long day = (todayUnixTime - birthdayUnixTime)/(60*60*24*1000);//시*분*초*1/1000이니까 1000을 곱함
		System.out.println("내가 살아온 날 : " + day);
	}
}
