package example_09_28_anonymous;

import java.awt.*;//전부다 import하겠다.
import java.awt.event.*;
import javax.swing.*;

public class MyApplication extends JFrame {

	public MyApplication() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("파일");
		//메뉴 아이템은 이벤트 소스 다
		JMenuItem newMenuItem = new JMenuItem("새글");
		JMenuItem openMenuItem = new JMenuItem("열기");
		JMenuItem saveMenuItem = new JMenuItem("저장하기");
		JMenuItem exitMenuItem = new JMenuItem("종료하기");
		
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		
		//이벤트 리스너를 익명객체로 만들기 
		/*
		 * 각이벤트 별로 핸들러 만들기 
		 * 이벤트 핸들러(익명객체)를 제작할 때 사용하는 부모 인터페이스 
		 * public interface ActioListener{//이것말고도 마우스 등이 많음 ,많이 사용하는 것
		 * void actionPerformed(ActionEvent event);
		 * }
		 * 
		 * ActionListener newFileListener = new ActionListener() {
		 * public void actionPerformed(ActionEvent event) {
		 * 새파일을 엽니다 
		 * }
		 * 
		 * ActionListener openFileListener = new ActionListener() {
		 * public void actionPerformed(ActionEvent event) {
		 * 새파일을 엽니다 
		 * }
		 */
		//익명객체 생성하기 - 각각의 이벤트소스에서 사용자와의 상호작용으로 이벤트가 발생했을 때 실행할 코드가 재정의 되어 있는 익명객체 생성하기 
		ActionListener newFileListener = new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JOptionPane.showMessageDialog(null, "새 파일을 엽니다.", "새 파일", JOptionPane.INFORMATION_MESSAGE);
	         };
	      };
	      ActionListener openFileListener = new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	             JOptionPane.showMessageDialog(null, "파일을 불러옵니다.", "불러오기", JOptionPane.INFORMATION_MESSAGE);
	          };
	       };
	       ActionListener saveFileListener = new ActionListener() {
	           public void actionPerformed(ActionEvent e) {
	              JOptionPane.showMessageDialog(null, "파일을 저장합니다.", "저장하기", JOptionPane.INFORMATION_MESSAGE);
	           };
	        };
	        ActionListener exitFileListener = new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               JOptionPane.showMessageDialog(null, "파일을 종료합니다.", "종료하기", JOptionPane.INFORMATION_MESSAGE);
	            System.exit(0);
	            };
	         };
	         
	         //익명 객체로 구현한 이벤트 리스너 (이벤트 핸들러 )객체를 이벤트 소스에 등록하기 
	         newMenuItem.addActionListener(newFileListener);
	         openMenuItem.addActionListener(openFileListener);
	         saveMenuItem.addActionListener(saveFileListener);
	         exitMenuItem.addActionListener(exitFileListener);
	      
	      
	      
		menuBar.add(fileMenu);
		
		this.setJMenuBar(menuBar);		
		
		this.setBounds(200, 200, 400, 300);
		//왼쪽에서 200 , 오른쪽 200 높이 300 너비 400
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyApplication();
	}

}
