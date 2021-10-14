package example_10_14_reader_writer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ScoreWriter {
	public static void main(String[] args) {
		
		List<Score> scoreList = new ArrayList<>();
		scoreList.add(new Score("홍길동",100,100,100));
		scoreList.add(new Score("김유신",90,70,80));
		scoreList.add(new Score("이순신",60,70,70));
		scoreList.add(new Score("강감찬",80,70,70));
		scoreList.add(new Score("류관순",100,90,90));
	
		//List객체에 저장된 학생성적 정보를 Score.txt파일로 저장하기 
		try (PrintWriter writer = new PrintWriter("c:/temp/doc/score.txt")) {
			StringBuilder sb = new StringBuilder();
		//try()안에 작성하게 되면 Auto close가 된다. 
		for(Score score : scoreList) {
			sb.append(score.getName() + ",");
			sb.append(score.getKor() + ",");
			sb.append(score.getEng() + ",");
			sb.append(score.getMath() + ",");
			
			writer.println(sb.toString());
			sb.setLength(0);//String배열에 들어있는 데이터의 0으로 만들어버림, 데이터를 지워버리는 역활을 수행한다. 
			//save버튼을 만들어서 입력을 할 수 있다. 
			//파일에 저장하는 이유 = 데이터를 영속화하기 위해서, 
			//파일의 데이터를 영속화 할 수 있다. 
		}
		
		//화면에 출력과 파일에 출력하는 것과 똑같다. 
		//그때그때마다 파이프의 종류만 다르다. 
		
		//writer.close();//항상적어줘야함.
		
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	
	}

}
