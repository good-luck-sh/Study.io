package kr.co.jhta.dao;

import java.util.Date;
import java.util.List;

import kr.co.jhta.vo.User;

public class UserDao {

	List<User> db = List.of(new User("hong", "1234", "홍길동", new Date()), 
						    new User("kim", "1234", "김유신", new Date()),
						    new User("kang", "1234", "강감찬", new Date()));
	
	public User getUserById(String id) {
		for (User user : db) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
	
	public void insert(User user) {
		db.add(user);
	}
}
