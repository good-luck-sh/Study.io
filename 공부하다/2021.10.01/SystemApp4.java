package example_10_01_system;

import java.util.Properties;
import java.util.Set;

public class SystemApp4 {

	public static void main(String[] args) {
		// 시스템의 정보를 조회할 수 있다. 
		//시스템의 운영체제, 시스템의 아키텍처, 설치의 자바에 대한 정보를 제공한다. 
		//App3은 환경정보를 조회했다면 여기서는 시스템의 정보를 조회할 수 있다. 
		Properties prop = System.getProperties();
		
		Set<Object> keys = prop.keySet();
		for(Object key : keys) {
			String name = (String)key;
			String value = prop.getProperty(name);
			System.out.println("[" + name + "]" +value);
		}
		
	
	
	}
}
