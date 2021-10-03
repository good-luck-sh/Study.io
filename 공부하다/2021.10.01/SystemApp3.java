package example_10_01_system;

import java.util.Map;
import java.util.Set;

public class SystemApp3 {


	public static void main(String[] args) {
		//System은 시스템과 관련된 환경설정 정보를 제공한다. 
		//반환타입확인하삼
		//컴퓨터의 사용자 환경변수정보와 시스템 환경변수 정보를 제공한다 
		// 이 컴퓨터의 JDK 설치 폴터를 조회하기 
		
		String javaHome = System.getenv("JAVA_HOME");
		System.out.println(javaHome);
		//환경변수라고 부르는 것들이다. 
		
		//이 컴퓨터의 사용자 이름을 조회하기 
		String userName = System.getenv("USERNAME");
		System.out.println(userName);
		
		/*
		 * Map<String, String> env = System.getenv(); Set<Map.Entry<String, String>>
		 * entries = env.entrySet();
		 * 
		 * 
		 * for(Map.Entry<String, String> entry : entries) { System.out.println("[" +
		 * entry.getKey() +"]" + entry.getValue()); }
		 */
	}
}
