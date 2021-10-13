package example_10_13_custom_exception.service;

import java.util.ArrayList;
import java.util.List;

import example_10_13_custom_exception.exception.PasswordMismatchException;
import example_10_13_custom_exception.exception.UserAlreadyExistsException;
import example_10_13_custom_exception.exception.UserNotFoundException;
import example_10_13_custom_exception.vo.User;

public class UserService {

	private List<User> users = new ArrayList<>();
	private User loginUser = null;
	
	public void registerUser(User user) {
		User savedUser = this.getUserById(user.getId());
		if(savedUser != null) {
			throw new UserAlreadyExistsException("["+user.getId()+"] 이미 등록된 아이디 입니다. ");
			//좀더 구체적인 예외를 만들어서 던짐
		}
		users.add(user);
	}
	public void login(String id, String password) {
		User savedUser = this.getUserById(id);
		if(savedUser == null) {
			throw new UserNotFoundException("["+id+"] 사용자 정보를 찾을 수 없습니다. ");
		}
		if (!savedUser.getPassword().equals(password)) {
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다. ");
		}
		loginUser = savedUser;
		
	}
	public void logout() {
		if(loginUser != null) {
			loginUser = null;
		}
	}
	public boolean isLogined() {
		return loginUser != null; //true반환
	}
	public User getUserById(String id) {
		for(User user : users) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
}
