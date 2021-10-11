package example_10_05_4_generic_sample;

import java.util.Objects;

public class User {

	private String username; 		//사용자 이름
	private String password; 		//아이디
	private String userId;			//비밀번호	
	private int point;				//적립포인트
	
	public User() {}
	
	public User(String username, String userId, String password) {
		this.username = username;
		this.userId = userId;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public int hashCode() { //해시코드 재정의
		return Objects.hash(userId);
	}

	@Override
	public boolean equals(Object obj) { //동등성 비교 재정의
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userId, other.userId);
	}
	
}
