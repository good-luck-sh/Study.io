package example_09_29_String;

import java.util.Arrays;

public class StringApp2 {

	public static void main(String[] args) {
		String text = "넷플릭스 한국 오리지널 드라마 ‘오징어 게임’이 전 세계적으로 돌풍을 일으키자 해외 주요 매체들도 앞다퉈 열풍을 조명하고 있다.미국 CNN방송은 “정말 죽여준다”며 엄지를 치켜세웠고, 뉴욕포스트는 “전 세계에 대혼란을 일으켰다”고 평했다.CNN방송은 29일(현지시간) “‘오징어 게임’은 무엇이고 왜 사로잡는가”라는 제목의 기사에서 “넷플릭스의 최신 히트작(오징어 게임)은 정말 죽여준다”고 보도했다.이어 “오징어 게임이 화제를 불러일으킨다고 말하는 것은 절제된 표현”이라며 ‘오징어 게임’ 흥행이 “한국 영화 ‘기생충’에서 드러났던 것과 매우 비슷한 현상”이라고 평했다.‘오징어 게임’을 “빚더미 수렁에 깊이 빠진 참가자들이 거액의 상금을 타기 위해 어린이 게임에 참가한다는 내용의 드라마”라며 간략한 줄거리를 소개했다.";

		//위의 내용에서 "오징어"라는 단어는 몇번이나 나왔을까?
		
		//특정단어를 찾는 메소드는 존재하지 않음
		//0. 등장횟수를 저장할 변수를 생성하고, 0으로 초기화 한다.
		//1. text의 내용을 " "을 구분자로 활용해서 잘라서 배열로 획득한다. 
		//   		String[] split(String 구분문자열)을 활용하세요
		//2. 배열에 저장된 모든 단어들을 처음부터 끝까지 순서대로(향상된 for문 사용) 한 단어씩 조회한다. 
		//3. 조회된 단어에 "오징어"라는 문자열이 포함되어 있으면 등장횟수를 1증가시킨다. 
		//4. 등장횟수를 화면에 출력한다.
		
		//숫자를 셀 참조변수를 0으로 저장한다. 
		int wordcount = 0;
		//text를 " "을 구분자로 자를 split메소들를 설정후 String[]에 입력하고, 참조변수로 values를 입력한다.
		String[] values = text.split(" ");
		//향상된 for문을 사용하여, String타입의 value를 배열values을 저장한다.
		System.out.println(Arrays.toString(values));
		//문자열 배열을 출력한다. 
		for(String value : values ) {
			//"오징어"라는 단어가 true인지 false인지 나타내는 contains를 입력하여 count1값에 입력한다. 
			boolean count1 = value.contains("오징어");
			//만약 count1이 true라면 
			if(count1 == true) {
				//wordcount를 1증가한다. 
				wordcount += 1;
			}
		}
		//wordcount가 몇인지 출력한다. 
		System.out.println("총 등장횟수 : "+wordcount);
	//	System.out.println(text.split("오징어 게임").length);
		

		
	}
}
