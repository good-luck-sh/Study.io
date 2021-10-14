package example_10_14_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample1 {
	public static void main(String[] args) {
		//Reader에서는 이 친구만 기억한다. 
		//읽어올때는 BufferedReader가 짱이다. 
		/*
		 * BufferedReader
		 * 		-텍스트를 읽어오는 객체다. 
		 * 		-텍스트를 한 줄씩 읽어오는 String readLine()메소드를 제공한다. 
		 * 		-텍스트를 한 줄씩 읽어오는 객체는 이 친구밖에 없다. 
		 * 		-우리가 가져오는 텍스트의 데이터는 CSV의 형태로 가지고 온다. 
		 * 		//정형적인 데이터의 형식을 가지고 있다. 
		 * 		//불규칙한 데이터에서 읽어오는 경우는 존재하지 않는다. 
		 * 		-데이터 분석하는 경우도 로그Data도 반정형 데이터이기 때문에 어쨋거나 패턴을 가지고 있다. 
		 * 		-정형데이터 -규칙에 맞춰져있기 때문에 읽을 수 있다.  CSV가 대표적이다. 
		 * 			 한 줄씩 의미를 갖고있어서, 한줄씩 읽어내는 기능이 중요하다. BufferedReader밖에 없다. 
		 * 		-비정형데이터(일반text)
		 * 		-반정형데이터 - 일정한 형식을 가지고 있지만, 약간의 손을 거쳐야지 데이터를 읽을 수 있다. 
		 *		한 줄을 읽고 그 줄에서 읽어올 데이터가 없으면 null을 반환한다. 
		 *
		 *		-readLine()줄바꿈문자 앞까지 읽어서 반환한다. 
		 *		-readLine()은 더이상 읽어올 데이터가 없으면 (스트림의 끝에 도달하면) null을 반환한다. 
		 *
		 */
		try {
			//파일내용을 읽어오는 FileReader객체를 생성한다. 
			//FileReader의 읽기 메소드는 1글자씩만 읽어온다
			FileReader fileReader = new FileReader("c:/temp/doc/example2.txt");
			//스트림의 텍스트데이터를 한 줄씩 읽어오는 BufferedReader객체를 생성한다. 
			//BufferedReader가 읽어올 텍스트를 제공하는 FileReader객체를 BufferedReader한테 생성자 인자로 전달한다. 
			//파일의 텍스트 데이터를 읽어오는 FileReader를 BufferedReader에게 전달한다.
			
			BufferedReader reader = new BufferedReader(fileReader);
			String text = null;
			//text = reader.readLine() : 스트림에서 한줄씩 읽어서 text에 대입한다. 
			//(text = reader.readLine()) != null : text에 대입된 값이 null 아니면 true다. 즉, while문 블록내의 수행문이 실행된다.
			while((text = reader.readLine()) != null ) { //읽어온 것을 text에 담는다. 그리고 null이 아닐때까지로 설정
				//System.out.println(text);
				//텍스트 분석, 띄어쓰기가 있을 경우 에러가 난다. 
				String[] values = text.split(",");
				String name = values[0];
				int korScore = Integer.parseInt(values[1].trim());
				int engScore = Integer.parseInt(values[2].trim());
				int mathScore = Integer.parseInt(values[3].trim());
				int total = korScore + engScore + mathScore;
				int average = total/3;
				
				System.out.println("학생이름 : "+ name +" 총점 : "+ total +" 평균점수 : " + average);
			}
			
//			String text1 = reader.readLine();
//			String text2 = reader.readLine();
//			String text3 = reader.readLine();
//			String text4 = reader.readLine();
//			String text5 = reader.readLine();
//			String text6 = reader.readLine();
//			String text7 = reader.readLine();
//			
//			System.out.println(text1);
//			System.out.println(text2);
//			System.out.println(text3);
//			System.out.println(text4);
//			System.out.println(text5);
//			System.out.println(text6);
//			System.out.println(text7);//null 출력, 따로 오류가 나타나지 않는다. 
//			//몇번의 데이터가 나오는지 모르지만, null나올때까지만 출력되면 됨
			
			reader.close();//마지막에는 닫는 메소드를 작성해주어야한다. 
			} catch(IOException ex) {
			ex.printStackTrace();
		} catch(Exception ex) {
		
		}
	}

}
