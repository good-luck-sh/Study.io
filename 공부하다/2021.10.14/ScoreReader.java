package example_10_14_reader_writer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreReader {

	public static void main(String[] args) throws IOException{
		
		
		try(BufferedReader reader = new BufferedReader(new FileReader("c:/temp/doc/Score.txt"));){
		// 읽을 여러개의 정보이다. 
		// 행하나가 객체 하나에 대응됨, 여러개를 담기 위한 ArrayList가 필요함.
		List<Score> scores = new ArrayList<>();
		//Score.txt파일에서 읽어온 성적정보를 저장하는 ArrayList객체
		String text = null;
		while((text = reader.readLine()) != null) {
			//text -> "홍길동, 100,100,100"으로 읽을 수 있음
			
			//values - >["홍길동" , "100","100","100"]
			String[] values = text.split(",");
			//배열의 값 분석하기
			String name = values[0];
			int kor = Integer.parseInt(values[1]);
			int eng = Integer.parseInt(values[2]);
			int math = Integer.parseInt(values[3]);
			//Score 객체를 생성해서 분석된 성적정보를 입력하기 
			Score score = new Score(name, kor, eng, math);
			//성적 정보가 저장된 Score 객체를 ArrayList객체에 저장하기 
			scores.add(score);
			//객체로 만드는 이유
			//text로 되어있는 경우 계산하기 어렵다 
			
		}
		//데이터 조작/ 분석하기 
		//학생들의 전체 평균점수 계산하기 
		int totalAverage = 0;
		for(Score score : scores) {
			totalAverage += score.getAverage();
		}
		System.out.println("전체평균점수: " + totalAverage/scores.size() + "점");
		//평균점수에서 size를 나눠서 전체 평균을 작성할 수 있다. 
		
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
