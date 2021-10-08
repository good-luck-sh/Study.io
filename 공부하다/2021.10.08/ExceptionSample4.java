package example_10_08_exception;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionSample4 {

	public static void method1() throws IOException {
		File file = new File("c:/temp/java/sample.text");
		file.createNewFile();
		//method1에서 에러가 발생함 						//java.io.IOException 예외 발생
	}
	public static void method2() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date date = sdf.parse("2000-01-01");
		System.out.println(date);
		//method2에서도 에러가 발생하고 있다. 				//java.text.ParseException 예외 발생
	}
	public static void method3() throws IOException, ParseException, ClassNotFoundException{ //총 3개의 method의 Exception을 덤태기 씀
		Class.forName("java.util.ArrayList"); // 몇개던지 위임할 수 있다, 마지막까지 
		//method3에서도 에러가 발생하고 있다. 				//java.lang.ClassNotFoundException 예외 발생
		ExceptionSample4.method1(); //method1호출
		ExceptionSample4.method2(); //method2호출
	}
	public static void method4() throws SQLException{
		DriverManager.getConnection("jbdc:oracle:thin@localhost:1521:xe");
	}
	
	public static void main(String[] args) {//너무 많은 예외처리가 이뤄짐 
		//예외를 막던지지 않고, 사용자가 담아둔 예외를 만들어서 그 하나를 던진다. 
		//자세한건 DB에서 다시 진행할 것임.
		try {
			ExceptionSample4.method3();
			ExceptionSample4.method4();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
