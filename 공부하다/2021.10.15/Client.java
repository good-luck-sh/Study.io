package simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {

	public static void main(String[] args) throws IOException{
		
		//이 컴퓨터 (127.0.0.1)에서 3000번 port를 사용중인 서버프로그램에게 연결요청을 보낸다. 
		Socket socket = new Socket("127.0.0.1",3000);//socket을 만들기만 해도 연결이 됨
		System.out.println("### 서버에 연결요청을 보냄");
		
		//이 소켓의 반대편 소켓(서버측 소켓)과 연결된 입력/출력 스트림을 획득
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//서버로 메세지 보내기 
		out.println("김쩡글");
		
		//서버가 보낸메세지 받기 
		String message = in.readLine();
		System.out.println("서버의 응답메세지 : " + message);
		
		socket.close();
		
		
	}
}
