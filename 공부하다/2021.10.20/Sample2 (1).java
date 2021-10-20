package example_10_20.jdbc.select;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.ConnectionUtil;

public interface Sample2  {

	public static void main(String[] args) throws SQLException {
//다른점		
//SQL	//같은점
		String sql = "select employee_id, first_name, last_name, email, phone_number, hire_date,job_id, salary, "
				+"  commission_pct, manager_id, department_id "
				+"from employees "
				+"order by employee_id asc ";
		//Connection 획득
		Connection connetion = ConnectionUtil.getConnection();
		
		//PreparedStatement 획득
		PreparedStatement psmt = connetion.prepareStatement(sql);
		
// ?에 값 바인딩
		//SQL 전송 및 ResultSet 획득
		ResultSet rs = psmt.executeQuery();
		
//ResultSet처리
		while(rs.next()) {
			int no = rs.getInt("employee_id"); 					//NUMBER(6,0)
			String firstName = rs.getString("first_name");		//VARCHAR2(20)
			String lastName = rs.getString("last_name");		//VARCHAR2(25)
			String email = rs.getString("email");				//VARCHAR2(20)
			String phoneNumber = rs.getString("phone_number");	//VARCHAR2(20)
			Date hireDate = rs.getDate("hire_date");			//DATE
			String jobId = rs.getString("job_id");				//VARCHAR2(10)
			double salary = rs.getDouble("salary");				//NUMBER(8,2)
			double commissionPct = rs.getDouble("commission_pct");//NUMBER(2,2)
			int managerId = rs.getInt("manager_id");				//NUMBER(6,0)
			int departmentId = rs.getInt("department_id");			//NUMBER(4,0)
			
			System.out.printf("%d %s %s %s %s %s %s %.2f %.2f %d %d\n",no,firstName,lastName,email,phoneNumber,hireDate,jobId,salary,commissionPct,managerId,departmentId);
			System.out.println("---------------------------------");
		}
		
		//자원해제 
		rs.close();
		psmt.close();
		connetion.close();
		
	}
}
