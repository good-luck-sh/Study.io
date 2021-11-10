package com.sample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	
	private static final String URL= "jdbc:oracle:thin:@LAPTOP-MP9I3VRU:1521:xe";
	private static final String USERNAME = "hr";
	private static final String PASSWORD= "zxcv1234";
	private ConnectionUtils() {}
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 데이터베이스와 연결을 담당하는 Connection 객체를 반환한다.
	 * @return 데이터베이스와 연결을 담당하는 Connection 객체
	 * @throws SQLException 데이터베이스 연결 오류
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
}
