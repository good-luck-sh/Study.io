package example_10_20.jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sample1 {

	public static void main(String[] args) {//throw로 던지던가 예외처리를 던져야한다. 
		try {
			//0. 실행할 SQL을 정의한다. 
			String sql = "insert into tb_scores(student_name, kor_score, eng_score, math_score) values(?,?,?,?)";
			//이렇게 생긴 쿼리를 작성할 예정
			
			
		// 1.Oracle 핵심 JDBC 드라이버 크래스를 JVM 메모리에 로딩시키기
		//   - Oracle 핵심 JDBC 드라이버 클래스가 JVM 메모리에 로딩됨
		//   - Oracle 핵심 JDBC 드라이버가 JVM의 드라이버 레지스터리에 등록됨
		//	 * 드라이버 레지스터리는 JDBC 드라이버 정보가 저장되는 곳이다. 
		//   * DriverManager 클래스를 사용해서 드라이버 레지스터리에 등록된 JDBC 드라이버를 사용할 수 있다. 
		Class.forName("oracle.jdbc.OracleDriver");
		
		// 2. Oracle 데이터베이스 접속 URL과 접속계정을 정의한다. 
		// 		-jdbc:oracle:thin은 드라이버 레지스터리에 등록된 oracle JDBC드라이버의 이름이다. 
		//		-@localhost는 RDBMS가 실행중이 컴퓨터의 이름 혹은 ip주소로 적는다 
		//		-1521는 RDBMS가 사용하는 포트번호다. 
		//		-xe는 데이터베이스 식별자 이름이다 (SID)
		String url = "jdbc:oracle:thin:@LAPTOP-MP9I3VRU:1521:xe";
		String username = "hr";
		String password = "zxcv1234";
		
		// 3. 드라이버 레지스터리에 등록된 oracle JDBC 드라이버를 이요해서 RDBMS와 연결하기 
		//-> 연결을 담당하는 Connection객체가 획득됨
		Connection connection = DriverManager.getConnection(url, username, password);
		
		// 4. SQL과 SQL 실행에 필요한 값을 RDBMS로 전송하고 실행결과를 받아오는 preparedStatement객체 획득하기 
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		// 5. SQL에 ?(바인딩 변수)가 있으면 ?에 갯수만큼 preparedStatement객체에 값을 저장한다. 
		//		insert into tb_scores(student_name, kor_score, eng_score, math_score) values(?, ?, ?, ?)
							//		  VARCHAR2(20)  NUMBER(3)  NUMBER(3)   NUMBER(3)		문자열(홑따음표하지않아도됨), 정수, 정수, 정수
		pstmt.setString(1, "을지문덕");
		pstmt.setInt(2, 100);
		pstmt.setInt(3, 90);
		pstmt.setInt(4, 90);
		
		// 6. preparedStatement 객체에 저장된 SQL과 값을 RDBMS로 전송하고 실행시킨다. 
		//		-int 	executeUpdate() : INSERT,UPDATE, DELETE SQL을 RDBMS로 전송/ 실행시킬 떄 사용하는 메소드다.
					//					: 추가/수정/삭제된 행의 갯수를 반환한다. 
		//		-ResultSet executeQuery() :SELECT SQL을 RDBMS로 전송/ 실행시킬 떄 사용하는 메소드다.
					//					: 조회결과를 포함하고 있는 ResultSet객체를 반환한다.
		
		int rowCount = pstmt.executeUpdate();
		System.out.println(rowCount + "개의 행이 추가되었습니다.");
		//거의 행을 1개만 추가하기 때문에 결과값은 1개의 행이 추가되었다고 나올 것임
		
		// 7. 데이터베이스 엑세스 작업이 완료되면 사용했던 자원을 해제 시킨다. 
		pstmt.close();
		connection.close();
		
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			// 현재 이렇게 적는 코드는 최악의 코드임. 디버깅 정보만 작성하면 안되고, 
			// throw new RuntimeException(ex);으로 집어던져야한다. 
			//항상 exception을 던져야함 지금은 main에서 작성하니까 안적는 것임
			//최악읜 예외처리 코드임. 발생한 예외를 잡고, 디버깅 정보만 출력함
			//만약 이 기능을 다은 곳에서 호출했다면 예외가 발생했는지 모르게 됨
		} catch (SQLException ex) {
			//데이터베이스 엑세스 작업할때 오류가 발생하면 전부 SQLException 예외가 발생된다. 
			ex.printStackTrace();
		}
		
		}
}
